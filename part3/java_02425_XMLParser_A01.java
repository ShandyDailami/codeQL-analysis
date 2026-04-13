import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.AccessControl;
import java.security.AccessControlProvider;
import java.security.SecurityPermission;

public class java_02425_XMLParser_A01 {
    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            NodeList nodeList = document.getElementsByTagName("user");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                Element element = (Element) node;

                String username = element.getAttribute("username");
                String password = element.getAttribute("password");

                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}