import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_03494_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a factory for the document builder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a builder for the document
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file into a DOM tree
            Document doc = builder.parse("src/main/resources/legacy.xml");

            // TODO: Perform security-sensitive operations related to A03_Injection

            // Print the content of the document
            printDocument(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printDocument(Document doc) {
        System.out.println(doc.getDocumentElement().getNodeName());
        System.out.println(doc.getFirstChild().getNodeName());
        // TODO: Print more nodes and attributes
    }
}