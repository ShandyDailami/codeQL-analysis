import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_39736_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Load and parse the XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("test.xml"));

            // Print all element names and attributes
            printElementsAndAttributes(doc);

            // Print the first element name and attribute
            printFirstElementAndAttribute(doc);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void printElementsAndAttributes(Document doc) {
        NodeList nodes = doc.getElementsByTagName("*");
        for (int i = 0; i < nodes.getLength(); i++) {
            Element element = (Element) nodes.item(i);
            System.out.println("Element: " + element.getTagName());
            NamedNodeMap attributes = element.getAttributes();
            for (int j = 0; j < attributes.getLength(); j++) {
                Node attribute = attributes.item(j);
                System.out.println("   Attribute: " + attribute.getNodeName() + " = " + attribute.getTextContent());
            }
        }
    }

    private static void printFirstElementAndAttribute(Document doc) {
        Element element = (Element) doc.getElementsByTagName("firstElement").item(0);
        System.out.println("First Element: " + element.getTagName());
        NamedNodeMap attributes = element.getAttributes();
        for (int i = 0; i < attributes.getLength(); i++) {
            Node attribute = attributes.item(i);
            System.out.println("   Attribute: " + attribute.getNodeName() + " = " + attribute.getTextContent());
        }
    }
}