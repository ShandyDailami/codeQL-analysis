import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.apache.xml.security.utils.SecurityUtils;
import org.xml.sax.helpers.DefaultHandler;

public class java_12476_XMLParser_A08 {
    public static void main(String[] args) {
        String xmlFile = "src/main/resources/example.xml"; // replace with your xml file path
        parseXml(xmlFile);
    }

    public static void parseXml(String xmlFile) {
        try {
            // Create a new instance of DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a new instance of DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Create a new instance of DefaultHandler
            DefaultHandler handler = new DefaultHandler();

            // Parse the XML file and build a Document object
            Document document = builder.parse(xmlFile, handler);

            // Print the document
            SecurityUtils.validate(document); // This will throw an IntegrityFailure exception if the document is not valid.
            System.out.println(document.getDocumentElement().getNodeName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}