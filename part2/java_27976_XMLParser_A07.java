import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_27976_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a new instance of the DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use the factory to create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document document = builder.parse(new File("path/to/your/file.xml"));

            // Get the root element of the document
            Element root = document.getDocumentElement();

            // Print the root element name
            System.out.println("Root element: " + root.getNodeName());

            // Get all child elements
            NodeList children = root.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                Node node = children.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Child element: " + element.getNodeName());
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}