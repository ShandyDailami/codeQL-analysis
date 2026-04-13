import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_17324_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a new DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Create a new DocumentBuilder
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the XML file
            Document doc = dBuilder.parse(new File("sample.xml"));

            // Get the root element of the document
            doc.getDocumentElement().normalize();

            // Print the text content of each element
            printElement(doc, doc.getDocumentElement());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElement(Document doc, Element elem) {
        System.out.println("Element name: " + elem.getNodeName());
        System.out.println("Element text: " + elem.getTextContent());

        NodeList children = doc.getElementsByTagName(elem.getTagName());

        for (int i = 0; i < children.getLength(); ++i) {
            printElement(doc, children.item(i) as Element);
        }
    }
}