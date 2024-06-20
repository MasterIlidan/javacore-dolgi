package laba10;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JsonParser {
    public static void main(String[] args) {
        try {
            JSONParser jsonParser = new JSONParser();
            Object object = jsonParser
                    .parse(new FileReader("./src/main/java/laba10/example.json"));
            JSONObject jsonObject = (JSONObject) object;
            System.out.println("Root element: " + jsonObject.keySet().iterator().next());
            JSONArray jsonArray = (JSONArray) jsonObject.get("books");

            for (Object book : jsonArray) {
                JSONObject bookObject = (JSONObject) book;
                System.out.println("\nCurrent element: book");
                System.out.println("Book name: " + bookObject.get("title"));
                System.out.println("Author: " + bookObject.get("author"));
                System.out.println("Year: " + bookObject.get("year"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        
    }
}
