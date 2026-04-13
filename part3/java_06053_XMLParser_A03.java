import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.IOException;

public class java_06053_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Step 2: Get the DocumentBuilder from the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Parse the XML document into a Document object
            Document document = builder.parse("input.xml"); //replace input.xml with your file path

            // Step 4: Process the Document object here.
            // For example, print out all element names and their values.
            document.getDocumentElement().normalize();
            System.out.println("Root element: " + document.getDocumentElement().getNodeName());

            // Step 5: Close the Document object to free up resources
            document.getDocumentElement().normalize();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}