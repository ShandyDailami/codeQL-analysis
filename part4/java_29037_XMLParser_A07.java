import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_29037_XMLParser_A07 {
    public static void main(String[] args) {
        // Create a DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Read the XML file
            Document document = builder.parse(new File("src/main/resources/sample.xml"));

            // Normalize the XML document
            document.getDocumentElement().normalize();

            // Get all the nodes
            NodeList nodes = document.getElementsByTagName("*");

            // For each node, print the node name and its value
            for (int i = 0; i < nodes.getLength(); i++) {
                System.out.println("Node " + (i + 1) + ": " + nodes.item(i).getNodeName());
            }

            // Authentication mechanism (simple check if the user name and password match the expected values)
            if (authenticate("admin", "password")) {
                System.out.println("Authentication successful!");
            } else {
                System.out.println("Authentication failed!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticate(String username, String password) {
        // Here we're going to just check if the input matches our expected values.
        // In a real-world scenario, you'd typically use a more secure method of authentication,
        // such as sending the username and password to a server and checking the response.
        return username.equals("admin") && password.equals("password");
    }
}