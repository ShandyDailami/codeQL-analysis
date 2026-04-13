import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileWriter;

public class java_11206_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Create a new factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use the factory to create a new document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("example.xml"));

            // Get the root element
            Element root = doc.getDocumentElement();

            // Print the names and values of all the elements
            printElements(root);

            // Write to a file
            FileWriter writer = new FileWriter("output.txt");
            writer.write("XML parsed and elements printed to output.txt");
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElements(Element element) {
        // Print the element name and value
        System.out.println("Element: " + element.getNodeName() + ", Value: " + element.getNodeValue());

        // Get the list of child nodes
        NodeList children = element.getChildNodes();

        // Print the names and values of all the child elements
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                printElements((Element) child);
            } else if (child.getNodeType() == Node.TEXT_NODE) {
                System.out.println("Text: " + child.getNodeValue());
            }
        }
    }
}