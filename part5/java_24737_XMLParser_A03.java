import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_24737_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a new DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a new DocumentBuilder using the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the input XML file into a Document
            Document doc = builder.parse("input.xml");

            // Process the document (e.g., print all element names)
            printDocument(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printDocument(Document doc) {
        // Print out all element names and their text content
        doc.getElementsByTagName("*").item(0).getChildNodes().item(0).getNodeValue();
    }
}