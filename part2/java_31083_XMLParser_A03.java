import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class java_31083_XMLParser_A03 {

    public static void main(String[] args) {
        String filePath = "src/main/resources/example.xml"; // Assuming the XML file is in the same directory as the Java file

        parseXMLFile(filePath);
    }

    public static void parseXMLFile(String filePath) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = null;
        try {
            doc = builder.parse(new File(filePath));
            doc.getDoctype();
        } catch (ParserConfigurationException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }

        // Get the root element
        Element rootElement = doc.getDocumentElement();

        // Print all element names
        System.out.println("Root element: " + rootElement.getNodeName());

        // Get all child nodes
        ListElement(rootElement);
    }

    static void ListElement(Element element) {
        // Print the element name and its value
        System.out.print("Name: " + element.getNodeName());
        System.out.print(", Value: " + element.getTextContent());

        // Get the list of children
        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                Element childElement = (Element) child;
                System.out.println("Child Element: " + childElement.getNodeName());
                System.out.println("Child Value: " + childElement.getTextContent());
            }
        }
    }
}