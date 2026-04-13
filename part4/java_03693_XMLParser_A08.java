import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_03693_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a factory for XML parsing
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Step 2: Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Parse the XML from the file
            Document document = builder.parse("src/main/resources/sample.xml");

            // TODO: Write code to parse and handle the document

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}