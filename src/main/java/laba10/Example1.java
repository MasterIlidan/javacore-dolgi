package laba10;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
1
Сделайте в текстовом редакторе свой файл в формате XML в зависимости от
варианта (Приложение 1).
2
Добавьте возможность записывать новые книги в XML-файл. Например,
пользователь может ввести данные о новой книге, а программа добавит новый
элемент <book> в XML-файл.
3
Добавьте возможность поиска книг по автору или году издания. Например,
пользователь может ввести автора или год издания, а программа выведет список
книг, удовлетворяющих этому критерию поиска.
4
Реализуйте функцию удаления книги из XML-файла. Например, пользователь
может ввести название книги, которую хочет удалить, и программа удалит
соответствующий элемент <book> из XML-файла.
Вариант 10 Музыкальные произведения
*/
public class Example1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        XMLSongListEditor songList = new XMLSongListEditor();
        int input;
        while (true) {
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
                    songList.saveXMLFile();
                    System.exit(0);
                }
            }
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

class XMLSongListEditor {
    private Document songListDocument;
    private final Element songList;

    XMLSongListEditor() {
        if (!Files.exists(Path.of("song list.xml"))) {
            System.out.println("song list.xml don't exist. Creating...");
            try {
                createXMLFile();
            } catch (IOException e) {
                System.out.println("Error while creating song list.xml");
                e.printStackTrace();
            }
        }
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            songListDocument = documentBuilder.parse("song list.xml");
            songList = (Element) songListDocument.getElementsByTagName("songs").item(0);
        } catch (ParserConfigurationException e) {
            System.out.println("Document Builder Factory Error");
            throw new RuntimeException(e);
        } catch (IOException | SAXException e) {
            throw new RuntimeException(e);
        }

    }

    private void createXMLFile() throws IOException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        songListDocument = documentBuilder.newDocument();
        Element rootElement = songListDocument.createElement("songs");
        songListDocument.appendChild(rootElement);
        saveXMLFile();
    }

    public void saveXMLFile() {
        System.out.print("Saving...");
        try {
            songListDocument.setXmlStandalone(true);
            songListDocument.normalizeDocument();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
            DOMSource source = new DOMSource(songListDocument);
            StreamResult result = new StreamResult(new File("song list.xml"));
            transformer.transform(source, result);

            System.out.println("XML-file successfully created!");
        } catch (TransformerException e) {
            System.out.println("Error while saving song list.xml");
        }
        System.out.println("Done");
    }

    public void addNewSong(String name, String author, String year) {
        Element song = songListDocument.createElement("song");

        Element songName = songListDocument.createElement("Название");
        songName.appendChild(songListDocument.createTextNode(name));
        Element songAuthor = songListDocument.createElement("Автор");
        songAuthor.appendChild(songListDocument.createTextNode(author));
        Element songYear = songListDocument.createElement("Год_релиза");
        songYear.appendChild(songListDocument.createTextNode(year));

        song.appendChild(songName);
        song.appendChild(songAuthor);
        song.appendChild(songYear);

        songList.appendChild(song);
        saveXMLFile();
    }

    public void removeSong(String keyword) {
        NodeList nodeList = songList.getElementsByTagName("Название");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element songElement = (Element) nodeList.item(i);
            Element parentElement = (Element) songElement.getParentNode();
            if (parentElement.getTextContent().contains(keyword)) {
                Element mainElement = (Element) parentElement.getParentNode();
                mainElement.removeChild(parentElement);
            }
        }
        saveXMLFile();
    }

    public ArrayList<String> getSong(String keyWord) {
        NodeList nodeList = songList.getElementsByTagName("Название");

        //System.out.println(nodeList.getLength());

        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < nodeList.getLength(); i++) {

            Element songElement = (Element) nodeList.item(i);
            Element parentElement = (Element) songElement.getParentNode();

            //System.out.println(songElement.getTextContent());
            String rawDataFromXML = parentElement.getTextContent();

            if (!rawDataFromXML.contains(keyWord)) {
                continue;
            }

            ArrayList<String> songData = cleanUpRawData(rawDataFromXML);

            String resultString = songData.get(0) + "," + songData.get(1) + "," + songData.get(2);

            //System.out.println(rawDataFromXML);

            result.add(resultString);
        }

        return result;
    }


    private ArrayList<String> cleanUpRawData(String rawData) {
        ArrayList<String> temp = new ArrayList<>(List.of(rawData.split("\n")));
        for (int arrayListIndex = 0; arrayListIndex < temp.size(); arrayListIndex++) {
            boolean foundFlag = false;
            char[] chars = temp.get(arrayListIndex).toCharArray();

            for (char c : chars) {
                if (!(c == ' ')) {
                    foundFlag = true;
                    break;
                }
            }

            //если это строка без символов - удаляем её и переходим к следующей
            if (!foundFlag) {
                temp.remove(arrayListIndex);
                arrayListIndex--;
                continue;
            }

            //убираем лишние пробелы
            temp.set(arrayListIndex, temp.get(arrayListIndex).trim());
        }
        return temp;
    }
}
