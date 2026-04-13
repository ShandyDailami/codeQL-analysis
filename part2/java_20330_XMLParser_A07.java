import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_20330_XMLParser_A07 {

    public static void main(String[] args) {

        // Step 1: Create a DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Step 2: Parse the XML file
        try {
            Document document = builder.parse("path/to/your/file.xml");

            // Step 3: Handle the document
            System.out.println("Document successfully parsed.");

        } catch (Exception e) {
            System.out.println("Failed to parse the XML file.");
            e.printStackTrace();
        }
    }
}