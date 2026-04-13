import java.io.FileInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_21159_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a factory for building a new Document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a builder with a new Document
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new FileInputStream("sample.xml"));

            // Print the document elements
            printElements(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printElements(Document doc) {
        doc.getDocumentElement().normalize();
        System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());

        // Print all element nodes
        printElements(doc.getDocumentElement());
    }

    public static void printElements(org.w3c.dom.Node node) {
        // Print all child nodes
        if (node.hasChildNodes()) {
            node.getChildNodes().forEach(MyXMLParser::printElements);
        }

        System.out.println("Node Name: " + node.getNodeName());
        System.out.println("Node Value: " + node.getNodeValue());
    }
}