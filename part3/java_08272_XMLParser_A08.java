import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class java_08272_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Step 1: Create a DocumentBuilderFactory instance
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Step 2: Get a document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Parse the XML document
            Document document = builder.parse("src/example.xml");

            // Step 4: Process the XML document (e.g., print the document)
            document.getDocumentElement().getFirstChild().normalize();
            System.out.println("Document Element: " + document.getDocumentElement().getNodeName());

            // Step 5: Handle exceptions
        } catch (ParserConfigurationException | SAXException | SAXParseException e) {
            e.printStackTrace();
        }
    }
}