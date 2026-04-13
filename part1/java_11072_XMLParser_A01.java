import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_11072_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Step 1: Create a DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 2: Parse the XML file
            Document doc = builder.parse(new File("broken_access_control.xml"));

            // Step 3: Get the root element
            Element root = doc.getDocumentElement();

            // Step 4: Get all 'access' elements
            NodeList accessList = root.getElementsByTagName("access");

            // Step 5: Iterate over 'access' elements
            for (int i = 0; i < accessList.getLength(); i++) {
                Element accessElement = (Element) accessList.item(i);

                // Step 6: Get 'user', 'role' and 'permission' elements
                String user = accessElement.getElementsByTagName("user").item(0).getTextContent();
                String role = accessElement.getElementsByTagName("role").item(0).getTextContent();
                String permission = accessElement.getElementsByTagName("permission").item(0).getTextContent();

                // Step 7: Print the results
                System.out.println("User: " + user);
                System.out.println("Role: " + role);
                System.out.println("Permission: " + permission);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}