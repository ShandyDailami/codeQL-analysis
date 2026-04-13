import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_35990_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Load the XML file
            InputStream inputStream = new FileInputStream(new File("src/main/resources/sample.xml"));

            // Create a new factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a new document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the input stream into a Document
            Document doc = builder.parse(inputStream);

            // Get the root element
            Element root = doc.getDocumentElement();

            // Get all element nodes
            NodeList nodes = root.getChildNodes();

            // Iterate over each node
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);

                // Check if the node is an element
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    // Cast the node to an element
                    Element element = (Element) node;

                    // Get the element's name and value
                    String name = element.getTagName();
                    String value = element.getFirstChild().getNodeValue();

                    // Print the element's name and value
                    System.out.println("Element: " + name + ", Value: " + value);
                }
            }

            // Close the input stream
            inputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}