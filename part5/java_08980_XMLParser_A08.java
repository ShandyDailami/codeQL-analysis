import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_08980_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Step 2: Use DocumentBuilderFactory to get a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Parse the XML from a URL
            Document document = builder.parse("http://example.com/books.xml");

            // Print the document element and return its value
            printDocument(document);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printDocument(Document document) {
        // Print the document element and return its value
        // This is a placeholder, replace it with your own code
        System.out.println("Document Element: " + document.getDocumentElement().getNodeName());
    }
}