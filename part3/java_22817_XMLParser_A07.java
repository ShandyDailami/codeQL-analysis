import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_22817_XMLParser_A07 {
    public static void main(String[] args) {
        File xmlFile = new File("books.xml");

        // Create a DocumentBuilderFactory
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        try {
            // Create a DocumentBuilder
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the XML file
            Document doc = dBuilder.parse(xmlFile);

            // Get the book list from the document
            NodeList bookList = doc.getElementsByTagName("book");

            // Iterate over each book and print its details
            for (int i = 0; i < bookList.getLength(); i++) {
                System.out.println("Book #" + (i + 1));

                // Get each book's details
                Node bookNode = bookList.item(i);
                NodeList details = bookNode.getChildNodes();
                for (int j = 0; j < details.getLength(); j++) {
                    Node detailNode = details.item(j);
                    System.out.println(detailNode.getNodeName() + ": " + detailNode.getTextContent());
                }

                System.out.println("-----------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}