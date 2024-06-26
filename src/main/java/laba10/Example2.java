package laba10;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
1
Сделайте в текстовом редакторе свой файл в формате JSON в зависимости от
варианта (Приложение 1).
2
Добавьте функционал для поиска книг по автору.
3
Добавьте функционал для добавления новой книги в массив.
4
Добавьте функционал для удаления книги из массива по названию.
Вариант 10 Музыкальные произведения
*/
public class Example2 {
    private static final Logger log = Logger.getLogger(Example2.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        JSONListEditor songList;
        try {
            songList = new JSONListEditor();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            while (true) {
                int input;
                printMenu();
                input = scanner.nextInt();
                scanner.nextLine();
                switch (input) {
                    case 1: {
                        System.out.print("Enter song name: ");
                        String songName = scanner.nextLine();
                        System.out.print("Enter song artist: ");
                        String artist = scanner.nextLine();
                        System.out.print("Enter song year: ");
                        String year = scanner.nextLine();

                        songList.addNewSong(songName, artist, year);
                        break;
                    }
                    case 2: {
                        System.out.print("Enter key word for search: ");
                        String keyword = scanner.nextLine();
                        songList.removeSong(keyword);
                        break;
                    }
                    case 3: {
                        System.out.print("Enter key word for search: ");
                        String keyword = scanner.nextLine();
                        ArrayList<String> searchResult = songList.getSong(keyword);
                        System.out.println("Results: " + searchResult.size());
                        if (searchResult.isEmpty()) break;
                        System.out.println("Name\tArtist\tYear");
                        for (String serializedSong : searchResult) {
                            String[] song = serializedSong.split(",");
                            System.out.println(song[0] + "\t"
                                    + song[1] + "\t"
                                    + song[2]);
                        }
                        break;
                    }
                    case 4: {
                        System.out.println("Exiting...");
                        try {
                            songList.saveJSONFile();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        System.exit(0);
                    }
                }
            }

        } catch (IOException e) {
            log.log(Level.WARNING, "Error saving JSON file", e);
            throw new RuntimeException(e);
        }
    }

    private static void printMenu() {
        System.out.println("""
                1. Add to songs list
                2. Delete from songs list
                3. Search song in list
                4. Exit
                """);
    }
}

class JSONListEditor {
    private JSONObject songListDocument;
    private JSONArray songList;

    Logger log = Logger.getLogger("JSONListEditor");

    private final String fileName = "song list.json";

    JSONListEditor() throws IOException {

        if (!Files.exists(Path.of(fileName))) {
            log.info(fileName + " don't exist. Creating...");
            createJSONFile();
        } else {
            try {
                JSONParser jsonParser = new JSONParser();
                Object object = jsonParser
                        .parse(new FileReader(fileName));
                songListDocument = (JSONObject) object;
                songList = (JSONArray) songListDocument.get("songs");
            } catch (ParseException e) {
                log.log(Level.WARNING, "An error occurred while reading the JSON file.", e);
                throw new RuntimeException(e);
            }
        }
    }

    private void createJSONFile() throws IOException {
        songListDocument = new JSONObject();

        songList = new JSONArray();

        saveJSONFile();
    }

    public void saveJSONFile() throws IOException {
        log.info("Saving...");

        songListDocument.put("songs", songList);

        FileWriter file = new FileWriter(fileName);
        file.write(songListDocument.toJSONString());
        file.close();

        log.info("Saving done");
    }

    public void addNewSong(String name, String author, String year) throws IOException {
        log.info("Adding new song");

        JSONObject song = new JSONObject();

        song.put("name", name);
        song.put("author", author);
        song.put("year", year);

        songList.add(song);

        saveJSONFile();
        log.info("Added new song: " + song.toJSONString());
    }

    public void removeSong(String keyWord) throws IOException {
        log.info("Searching songs: " + keyWord);
        ArrayList<JSONObject> toDeleteList = new ArrayList<>();
        songList.stream()
                .filter(book -> book instanceof JSONObject)
                .filter(book ->
                        keyWord.equals(((JSONObject) book).get("name")) |
                                keyWord.equals(((JSONObject) book).get("author")) |
                                keyWord.equals(((JSONObject) book).get("year"))
                )
                .forEach(book -> {
                    System.out.println("\nТекущий элемент: book");
                    JSONObject bookObject = (JSONObject) book;
                    /*System.out.println("Название книги: " + bookObject.get("name"));
                    System.out.println("Автор: " + bookObject.get("author"));
                    System.out.println("Год издания: " + bookObject.get("year"));*/
                    toDeleteList.add(bookObject);
                });
        log.info("Deleting " + toDeleteList.size() + " songs");

        for (JSONObject book : toDeleteList) {
            log.info("Removing song: " + book.toJSONString());
            songList.remove(book);
        }

        saveJSONFile();
    }

    public ArrayList<String> getSong(String keyWord) {
        log.info("Searching songs: " + keyWord);
        ArrayList<String> result = new ArrayList<>();
        songList.stream()
                .filter(book -> book instanceof JSONObject)
                .filter(book ->
                        keyWord.equals(((JSONObject) book).get("name")) |
                                keyWord.equals(((JSONObject) book).get("author")) |
                                keyWord.equals(((JSONObject) book).get("year"))
                )
                .forEach(book -> {
                    JSONObject bookObject = (JSONObject) book;
                    log.info("Found: " + ((JSONObject) book).toJSONString());
                    /*System.out.println("Название книги: " + bookObject.get("name"));
                    System.out.println("Автор: " + bookObject.get("author"));
                    System.out.println("Год издания: " + bookObject.get("year"));*/
                    String serializeSong = bookObject.get("name") + "," + bookObject.get("author") + "," + bookObject.get("year");
                    result.add(serializeSong);
                });
        log.info("Searching done. Found: " + result.size());
        return result;
    }
}
