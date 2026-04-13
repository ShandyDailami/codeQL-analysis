import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_38472_XMLParser_A03 {
    public static void main(String[] args) {
        String fileName = "src/main/resources/sample.xml";  // Use your file path here
        parseXML(fileName);
    }

    private static void parseXML(String fileName) {
        File inputFile = new File(fileName);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            Element root = doc.getDocumentElement();
            System.out.println("Root Element: " + root.getNodeName());

            printElement(root);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printElement(Element elem) {
        // Print all element details
        System.out.println("Element: " + elem.getNodeName());

        // Print attributes
        System.out.println("Attributes: ");
        for (int i = 0; i < elem.getAttributes().getLength(); i++) {
            System.out.println("Attribute: " + elem.getAttributes().item(i).getNodeName() + " = " + elem.getAttributes().item(i).getNodeValue());
        }

        // Print child nodes
        System.out.println("Child Nodes: ");
        for (int i = 0; i < elem.getChildNodes().getLength(); i++) {
            System.out.println("Child Node: " + elem.getChildNodes().item(i).getNodeName());
        }

        // Print element content
        System.out.println("Element Content: " + elem.getTextContent());

        // Recursively print all child elements
        for (int i = 0; i < elem.getChildNodes().getLength(); i++) {
            if (elem.getChildNodes().item(i).getNodeType() == Node.ELEMENT_NODE) {
                System.out.println("Element: " + elem.getChildNodes().item(i).getNodeName());
                printElement((Element) elem.getChildNodes().item(i));
            }
        }
    }
}