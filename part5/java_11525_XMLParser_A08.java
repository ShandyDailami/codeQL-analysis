import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_11525_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use the factory to create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("path_to_your_file.xml"));

            // Get the root element
            Element root = doc.getDocumentElement();

            // Print out the root element
            System.out.println("Root element: " + root.getNodeName());

            // Get all child elements
            NodeList childNodes = root.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node node = childNodes.item(i);
                System.out.println("Child element: " + node.getNodeName());
           
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Attribute: " + element.getAttribute("attribute_name"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}