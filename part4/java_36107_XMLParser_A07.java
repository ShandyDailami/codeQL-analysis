import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_36107_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory and use it to create a new DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file and store it in a Document object
            Document doc = builder.parse("src/main/resources/authFail.xml");

            // TODO: Process the XML document using your code here

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}