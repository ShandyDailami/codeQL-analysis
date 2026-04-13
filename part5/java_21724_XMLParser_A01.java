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
import org.xml.sax.SAXException;

public class java_21724_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Create a factory for building DOM trees
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a new document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file into a DOM tree
            Document document = builder.parse(new File("input.xml"));

            // Get the root element
            Element root = document.getDocumentElement();

            // Get all the elements in the document
            NodeList nodes = root.getChildNodes();

            // Iterate over each node
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);

                // If the node is an element, print its name and value
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Element: " + element.getNodeName());
                    System.out.println("Value: " + element.getFirstChild().getNodeValue());
                }
            }

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}