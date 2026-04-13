import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_23320_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Create a new document
            Document doc = builder.parse(new File("example.xml"));

            // Get the root element
            Element root = doc.getDocumentElement();

            // Print all the element names and their attributes
            printElements(root);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void printElements(Element element) {
        if (element.hasChildNodes()) {
            for (int i = 0; i < element.getChildNodes().getLength(); i++) {
                if (element.getChildNodes().item(i).getNodeType() == Node.TEXT_NODE) {
                    // This is a text node, do nothing
                } else {
                    // This is an element node
                    System.out.println("Element: " + element.getChildNodes().item(i).getNodeName());
                    printElements((Element) element.getChildNodes().item(i));
                }
            }
        }
    }
}