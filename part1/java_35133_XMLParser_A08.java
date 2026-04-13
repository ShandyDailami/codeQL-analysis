import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_35133_XMLParser_A08 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document doc = builder.parse("src/main/resources/security_sensitive_data.xml");

            // Verify the XML file
            System.out.println("XML file was parsed successfully.");

            // Extract and print all 'item' elements
            NodeList nodeList = doc.getElementsByTagName("item");
            System.out.println("Number of 'item' elements: " + nodeList.getLength());

            // Use a for loop to verify integrity of the XML file
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                // Add security-sensitive operations here, e.g., verify if item's value is within certain range
                // Here, the code for a security-sensitive operation is omitted for brevity.
            }

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}