import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_07752_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use factory to create a document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML document
            Document document = builder.parse(new File("sample.xml"));

            // Get the root element
            Element root = document.getDocumentElement();

            // Print all element names
            printElements(root);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printElements(Element element) {
        // Print the element name
        System.out.println(element.getNodeName());

        // Get all child elements
        NodeList children = element.getChildNodes();

        // Loop through all child nodes
        for (int i = 0; i < children.getLength(); i++) {
            // Print the name of each child node
            printElements((Element) children.item(i));
        }
    }
}