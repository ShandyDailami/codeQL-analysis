import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.IOException;

public class java_07065_XMLParser_A03 {
    public static void main(String[] args) {
        // Create a DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // Use DocumentBuilderFactory to create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Use DocumentBuilder's parse method to parse the XML file
            Document document = builder.parse("src/main/resources/injection.xml");

            // Handle XML parsing
            System.out.println("XML Parsing Successful!");

        } catch (SAXException e) {
            e.printStackTrace();
       
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}