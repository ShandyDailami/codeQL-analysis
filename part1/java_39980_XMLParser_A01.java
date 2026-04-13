import java.awt.print.Book;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_39980_XMLParser_A01 {
    public static void main(String[] args) {
        String filePath = "books.xml"; // Path to the XML file

        // Create DocumentBuilderFactory and parse XML file
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = null;

        try {
            document = builder.parse(new File(filePath));
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }

        // Extract book titles
        getBookTitles(document);
    }

    private static void getBookTitles(Document document) {
        NodeList nodeList = document.getElementsByTagName("book");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            String title = element.getElementsByTagName("title").item(0).getTextContent();
            System.out.println("Book " + (i + 1) + ": " + title);
        }
    }
}