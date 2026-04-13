import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_07447_XMLParser_A03 {
    public static void main(String[] args) throws ParserConfigurationException, IOException {
        // Create the factory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Create the builder
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parse the XML document
        Document doc = builder.parse(new File("sample.xml"));

        // Get the root element
        Element root = doc.getDocumentElement();

        // Get and print all element names
        printElementNames(root);

        // Get the first child element of the root element
        Element firstChild = root.getFirstChildElement();

        // Get and print all attribute names
        printAttributes(firstChild);
    }

    private static void printElementNames(Element element) {
        System.out.println("Element Name: " + element.getTagName());

        // Get all child elements
        List childElements = element.getChildElements();
        for (int i = 0; i < childElements.size(); i++) {
            printElementNames((Element) childElements.get(i));
        }
    }

    private static void printAttributes(Element element) {
        System.out.println("Attributes of Element: " + element.getNodeName());

        // Get all attribute names
        NamedNodeMap attributes = element.getAttributes();
        for (int i = 0; i < attributes.getLength(); i++) {
            System.out.println(attributes.item(i).getNodeName() + "=" + attributes.item(i).getNodeValue());
        }

        // Get all child elements
        List childElements = element.getChildNodes();
        for (int i = 0; i < childElements.size(); i++) {
            if (childElements.get(i).getNodeType() == Node.ELEMENT_NODE) {
                printAttributes((Element) childElements.get(i));
            }
        }
    }
}