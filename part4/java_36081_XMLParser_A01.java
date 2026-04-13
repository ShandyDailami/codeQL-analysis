import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_36081_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Create a factory for building a document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use the factory to create a new document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the input file into a Document object
            Document doc = builder.parse(new File("input.xml"));

            // Retrieve the root element
            Element root = doc.getDocumentElement();

            // Print out the names of all the elements
            printElementNames(root);

            // Close the document
            doc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElementNames(Element element) {
        System.out.println("Element: " + element.getNodeName());

        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element child = (Element) node;
                printElementNames(child);
            }
        }
    }
}