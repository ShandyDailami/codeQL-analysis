import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_10066_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a factory for our document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use the factory to create a new document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Use the builder to parse the source file and construct a document
            Document doc = builder.parse(new File("sample.xml"));

            // Get the root element of the document
            Element root = doc.getDocumentElement();

            // Get all child elements
            NodeList nodes = root.getChildNodes();

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    // Extract and print the data
                    String name = element.getAttribute("name");
                    String value = element.getAttribute("value");
                    System.out.println("Name: " + name);
                    System.out.println("Value: " + value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}