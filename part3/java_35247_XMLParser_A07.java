import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_35247_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Step 2: Use the factory to create a DocumentBuilder
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Step 3: Read the XML file
            Document doc = dBuilder.parse("input.xml"); // replace with your xml file

            // TODO: Handle the document here.

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}