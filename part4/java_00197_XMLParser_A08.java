import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.IOException;

public class java_00197_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a factory for the DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a new document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(XmlParser.class.getResourceAsStream("/sample.xml"));

            // Print out the parsed XML
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getElementsByTagName("note").item(0).getTextContent());

        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}