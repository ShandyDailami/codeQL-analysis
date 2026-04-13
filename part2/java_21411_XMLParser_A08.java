import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_21411_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Step 1: Create DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 2: Parse the XML file
            Document doc = builder.parse("src/A08_IntegrityFailure.xml");

            // Step 3: Perform security-sensitive operations (e.g., check for integrity)
            // Here, we're just printing out the document's XML declaration
            System.out.println(doc.getXmlDeclaration());

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}