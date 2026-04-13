import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_05815_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Get the builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("brokenAccessControl.xml"));

            // TODO: Implement security-sensitive operations related to A01_BrokenAccessControl

            // Print the XML document
            doc.getDocumentElement().normalize();
            System.out.println("Formatted XML file: " + doc.getDocumentElement().getQualifiedName());

        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}