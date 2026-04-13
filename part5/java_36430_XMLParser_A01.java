import java.io.File;
import java.io.IOException;
import java.security.AccessControlException;
import java.security.SecurityPermission;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_36430_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("src/main/resources/broken_access_control.xml");
            parseXMLFile(xmlFile);
        } catch (IOException | AccessControlException | SecurityException e) {
            e.printStackTrace();
        }
    }

    private static void parseXMLFile(File xmlFile) throws IOException, AccessControlException, SecurityException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlFile);
        document.getDocumentElement().normalize();

        List<String> permissions = document.getElementsByTagName("permission").asList(SecurityPermission.class);
        if (permissions != null) {
            for (String permission : permissions) {
                System.out.println("Permission: " + permission);
                // Here you can implement logic related to security-sensitive operations
            }
        }
    }
}