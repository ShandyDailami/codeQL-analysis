import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_03670_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a factory for handling document building tasks
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use factory to create a document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document document = builder.parse("src/main/resources/example.xml");

            // Print out the XML document
            document.getDocumentElement().normalize();
            System.out.println("Root element: " + document.getDocumentElement().getNodeName());
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}