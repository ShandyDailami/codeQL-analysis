import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_20572_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Step 1: Create a factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Step 2: Use the factory to create a new builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Parse the XML document
            Document doc = builder.parse("sample.xml");

            // Here, you would handle the parsed document, for example, print out all the
            // element names and text inside each element
            doc.getDocumentElement().getFirstChild().getNodeName();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}