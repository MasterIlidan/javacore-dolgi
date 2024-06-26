package laba10;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
1
Добавьте функционал записи полученных данных в файл для сохранения
информации на будущее.
2
Добавьте обработку ошибок при получении HTML-кода страницы, например
вывод сообщения об ошибке и попытка переподключения к сайту.
*/
public class Example3 {
    static Logger log = Logger.getLogger(Example3.class.getName());

    public static void main(String[] args) {
        String url = "https://itlearn.ru/first-step";
        int attempts = 0;
        int maxAttempts = 3;

        while (true) {
            attempts++;
            log.info("Attempt %d/%d: Connecting to %s".formatted(attempts, maxAttempts, url));
            try {
                Document document = Jsoup.connect(url).get();
                log.info("HTML-page received. Processing...");
                Elements links = document.select("a[href]");
                ArrayList<String> linksList = new ArrayList<>();
                for (Element link : links) {
                    //System.out.println(link.attr("abs:href"));
                    linksList.add(link.attr("abs:href"));
                }
                saveResults(linksList);
                break;
            } catch (IOException e) {
                log.warning("Http status: " + ((HttpStatusException) e).getStatusCode());
                log.log(Level.WARNING, "Error occurred while loading page", e);
                if (attempts > 3) {
                    log.warning("Run out of " + maxAttempts + " attempts. Giving up...");
                    break;
                }

            }
        }
    }
    private static void saveResults(ArrayList<String> linksList){
        StringBuilder buffer = new StringBuilder();
        String lineNumber = "Link %d: ";
        String lineBreak = System.lineSeparator();
        String fileName = "results.txt";
        log.info(("Saving %d results to " + fileName).formatted(linksList.size()));
        int index = 1;
        for (String link : linksList) {
            buffer.append(lineNumber.formatted(index++));
            buffer.append(link);
            buffer.append(lineBreak);
        }
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(buffer.toString());
        } catch (IOException e) {
            log.log(Level.WARNING, "Error occurred while saving results.txt", e);
            throw new RuntimeException(e);
        }
        log.info("Saved results to " + fileName);
    }
}
