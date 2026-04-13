import java.net.URL;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.SecureClassLoadingPermission;
import java.util.Collection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_30267_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Load the XML document
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            URL url = new URL("http://example.com/data.xml"); // Replace with your URL
            Document doc = dBuilder.parseURL(url.toString());

            // Print the XML document
            System.out.println(doc.getDocumentElement().getTagName());

        } catch (ParserConfigurationException | SAXException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    // The Permission class is not used here because we don't need permission related to security
    static class MyPermission extends Permission {
        public java_30267_XMLParser_A07(String name) {
            super(name);
        }
        public void checkGuard(PermissionCollection permcol) {}
        public boolean implies(Permission p) { return false; }
    }
}