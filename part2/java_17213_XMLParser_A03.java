import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_17213_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlFile = "sample.xml";

        // Step 1: Set up the DocumentBuilderFactory and DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Step 2: Parse the XML file and create a Document object
        Document document;
        try {
            document = builder.parse(xmlFile);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
            return;
        }

        // Step 3: Perform security-sensitive operations related to A03_Injection
        // For example, print the XML content
        document.getElementsByTagName("*").item(0).getFirstChild().getNodeValue();
    }
}