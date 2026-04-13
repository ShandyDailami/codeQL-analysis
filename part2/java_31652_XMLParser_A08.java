import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_31652_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Load the XML document
            Document doc = builder.parse(ClassLoader.getSystemResourceAsStream("legacy_xml.xml"));

            // Here, you would implement your security-sensitive operations related to A08_IntegrityFailure.
            // For now, let's just print the XML document to the console
            doc.getDocumentElement().normalize();
            System.out.println("Legacy XML Parsed Successfully!");

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}