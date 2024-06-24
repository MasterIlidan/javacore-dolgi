package laba10;

import jdk.jshell.spi.ExecutionControl;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.lang.model.util.Elements;
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
import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) throws ExecutionControl.NotImplementedException {
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
                    throw new ExecutionControl.NotImplementedException("delete from");
                }
                case 3: {
                    //throw new ExecutionControl.NotImplementedException("search from");
                    System.out.print("Enter key word for search: ");
                    String keyword = scanner.nextLine();
                    ArrayList<String> searchResult = songList.getSong(keyword);
                    System.out.println("Results: " + searchResult.size());
                    if (searchResult.isEmpty()) break;
                    System.out.println("Song Name\tArtist\tYear");
                    for (String serializedSong : searchResult) {
                        String[] song = serializedSong.split(",");
                        System.out.println(song[0] + "\t"
                                + song[1] + "\t"
                                + song[2]);
                    }
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

    public ArrayList<String> getSong(String keyWord) {
        //TODO: разобраться с поиском элементов
        NodeList nodeList = songList.getElementsByTagName("Название");

        System.out.println(nodeList.getLength());
        for (int i = 0; i < nodeList.getLength(); i++) {
            //System.out.println(nodeList.item(i));
            Element songElement = (Element) nodeList.item(i);
            Element parentElement = (Element) songElement.getParentNode();


            System.out.println(songElement.getTextContent());
            String string = parentElement.getTextContent();
            string = string.replace("\n", "");

            String[] stringArray = string.split(" ");
            string = stringArray[0] + "," + stringArray[1] + "," + stringArray[2];
            System.out.println(string);

            /*Element name = (Element) childNodes.item(0);
            Element artist = (Element) childNodes.item(1);
            Element year = (Element) childNodes.item(2);
            String song = name.getTextContent() + "," + artist.getTextContent() + "," + year.getTextContent();*/



            //System.out.println(song);;
            //node.getElementsByTagName("Название");
        }
        /*NodeList nodeList = songList.getElementsByTagName(keyWord);
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            NodeList song = nodeList.item(i).getParentNode().getChildNodes();
            String serializedSong = song.item(0).getTextContent() + ","
                    + song.item(1).getTextContent() + ","
                    + song.item(2).getTextContent();
            result.add(serializedSong);
        }*/
        ArrayList<String> result = new ArrayList<>();
        return result;
    }
}


