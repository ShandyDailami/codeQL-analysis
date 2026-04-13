import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_05775_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Step 1: Create a DocumentBuilderFactory and a DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 2: Use the DocumentBuilder to parse the XML file
            Document document = builder.parse("src/main/resources/example.xml");

            // Step 3: Handle the document
            handleDocument(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleDocument(Document document) {
        // Step 4: Access and handle the document elements and attributes
        // For simplicity, we'll just print out the document root's tag name
        System.out.println("Root element: " + document.getDocumentElement().getTagName());
    }
}