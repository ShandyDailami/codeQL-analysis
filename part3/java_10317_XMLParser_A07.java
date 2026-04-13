import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_10317_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Step 2: Use the factory to create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Use the builder to parse the XML document
            Document doc = builder.parse("src/input.xml");

            // Step 4: Handle the document here (e.g., print all elements)
            doc.getElementsByTagName("*").item(0).getFirstChild().getNodeValue();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}