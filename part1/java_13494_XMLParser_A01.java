import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_13494_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create DocumentBuilderFactory and set its SecurityEnabled property to true.
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setFeature("http://xml.org/sax/features/security", true);
            factory.setFeature("http://xml.org/sax/features/validation", true);
            factory.setFeature("http://xml.org/sax/features/namespaces", false);
            factory.setFeature("http://xml.org/sax/features/nonvalidating/content", false);

            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("your_xml_file.xml"));

            // Here, you can add the access control logic

            // Print out the content of the XML file
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}