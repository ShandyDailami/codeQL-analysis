import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class java_35759_XMLParser_A03 {

    public static void main(String[] args) {
        String fileName = "src/main/resources/sample.xml"; // Change this to the path of your XML file
        parseFile(fileName);
    }

    private static void parseFile(String fileName) {
        File file = new File(fileName);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            // Print out the elements and their contents
            printElementsAndContents(document);

        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void printElementsAndContents(Document document) {
        NodeList nodeList = document.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println("Element: " + nodeList.item(i).getNodeName());
            System.out.println("Contents: " + nodeList.item(i).getTextContent());
        }

        // Print out the elements and their contents in a stylistic way
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println("\nElement: " + nodeList.item(i).getNodeName());
            System.out.println("Contents: " + nodeList.item(i).getTextContent());
        }
    }
}