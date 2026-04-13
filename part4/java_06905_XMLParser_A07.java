import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_06905_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a factory for the XML parser
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true); // enable validation

            // Create a new DocumentBuilder from the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file into a Document object
            Document doc = builder.parse(new File("input.xml"));

            // TODO: Add your security-sensitive operations here

            // Print the XML document to the console
            doc.getDocumentElement().normalize();
            System.out.println(doc.getElements());

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}