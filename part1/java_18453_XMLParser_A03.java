import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_18453_XMLParser_A03 {

    public static void main(String[] args) {
        // Create DocumentBuilderFactory and Document
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            // Parse the XML file
            Document document = builder.parse(new File("sample.xml"));

            // Print out the document's elements and attributes
            printDocument(document);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to print document's elements and attributes
    private static void printDocument(Document document) {
        // Get the document root element
        Element root = document.getDocumentElement();

        // Print out the root element
        System.out.println("Root element: " + root.getNodeName());

        // Get all child elements
        NodeList childNodes = root.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);

            // Print out each child element
            System.out.println("Child element: " + node.getNodeName());
        }
    }
}