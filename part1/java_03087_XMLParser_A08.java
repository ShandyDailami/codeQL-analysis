import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_03087_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a factory for the DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a builder using the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse("src/example.xml");

            // Print out the XML content
            System.out.println(doc.getDocumentElement().getTagName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}