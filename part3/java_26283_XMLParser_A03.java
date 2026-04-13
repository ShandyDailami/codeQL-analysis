import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_26283_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "example.xml"; // example xml file

        try {
            // Step 1: Create a factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Step 2: Get a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Parse the XML file
            Document document = builder.parse(xmlFile);

            // Step 4: Get the root element
            Element root = document.getDocumentElement();

            // Step 5: Process the XML data
            processXmlData(root);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void processXmlData(Element root) {
        // Process your XML data here
    }
}