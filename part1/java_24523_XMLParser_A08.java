import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_24523_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("example.xml"); // replace with your xml file path

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = null;
        try {
            document = builder.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        document.getDocumentElement().normalize();

        NodeList nodeList = document.getElementsByTagName("book");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Document child = nodeList.item(i).getDocumentElement();

            String title = child.getElementsByTagName("title").item(0).getTextContent();
            String author = child.getElementsByTagName("author").item(0).getTextContent();
            String price = child.getElementsByTagName("price").item(0).getTextContent();

            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("Price: " + price);
        }
    }
}