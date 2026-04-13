import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.List;
import java.util.ArrayList;

public class java_25831_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("path/to/your/file.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            // Remove the comment
            // // Parse the XML document

            // Get all the 'user' nodes
            NodeList userNodes = document.getElementsByTagName("user");
            List<String> userNames = new ArrayList<>();

            // Extract the user name and password from each 'user' node
            for (int i = 0; i < userNodes.getLength(); i++) {
                Node userNode = userNodes.item(i);
                Element userElement = (Element) userNode;
                String name = userElement.getAttribute("name");
                String password = userElement.getAttribute("password");

                // Here, you should handle the security sensitive operations such as checking if the password is secure
                // For this example, we will just print it out
                System.out.println("User Name: " + name);
                System.out.println("User Password: " + password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}