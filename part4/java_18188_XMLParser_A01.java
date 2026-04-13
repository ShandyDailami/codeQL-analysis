import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

public class java_18188_XMLParser_A01 {
    public static void main(String[] args) {
        // Load the XML file
        File file = new File("path_to_your_xml_file");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = null;
        try {
            document = builder.parse(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Parse the XML file and check password strength
        NodeList nodeList = document.getElementsByTagName("user");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            Element element = (Element) node;
            String password = element.getAttribute("password");
            if (!isPasswordStrong(password)) {
                System.out.println("Password for user " + element.getAttribute("username") + " is not strong enough");
            } else {
                System.out.println("Password for user " + element.getAttribute("username") + " is strong enough");
            }
        }
    }
    
    // Method to check if password is strong enough
    private static boolean isPasswordStrong(String password) {
        // Here we are using a simple regular expression to check if the password is strong.
        // In a real-world scenario, you should use a more complex regular expression or other security measures.
        return Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$)", password);
    }
}