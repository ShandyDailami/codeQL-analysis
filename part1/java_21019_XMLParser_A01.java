import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_21019_XMLParser_A01 {

    public static void main(String[] args) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        try {
            // Parse the XML document
            Document doc = dBuilder.parse(new File("sample.xml"));

            // Print the parsed document
            printDocument(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printDocument(Document doc) {
        doc.getDocumentElement().normalize();
        System.out.println("\nDocument elements : " + doc.getElementsCount());
        printElement(doc.getDocumentElement());
    }

    private static void printElement(Element element) {
        System.out.println("\nElement: " + element.getNodeName());
        System.out.println("Element type: " + element.getNodeType());
        System.out.println("Element value: " + element.getNodeValue());

        NamedNodeMap children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            if (node.getNodeType() == Node.TEXT_NODE) {
                System.out.println("Text: " + node.getNodeValue());
            } else {
                printElement((Element) node);
            }
        }
    }
}