import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_32313_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory and set up a new DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file and create a new document
            Document doc = builder.parse("sample.xml");

            // Add your code here to handle the document...

        } catch (SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}