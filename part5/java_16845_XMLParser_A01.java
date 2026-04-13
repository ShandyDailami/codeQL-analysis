import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_16845_XMLParser_A01 {

    public static void main(String[] args) {

        // Create a DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // Use factory to create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML from the file
            Document doc = builder.parse(new File("input.xml"));

            // Print out the XML content
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        } catch (SAXException e) {
            e.printStackTrace();
       
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}