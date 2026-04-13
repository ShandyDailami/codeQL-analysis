import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_21400_XMLParser_A01 {

    public static void main(String[] args) {

        // Create a factory for the DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Create a builder for the Document
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parse the XML document
        Document doc = null;
        try {
            doc = builder.parse("path_to_your_xml_file.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }

        // TODO: Implement security-sensitive operations here

    }
}