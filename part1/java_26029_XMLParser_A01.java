import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.Policy;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.AccessControl;
import java.security.AccessController;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_26029_XMLParser_A01 {

    private static class Permissions implements Policy {
        public PermissionCollection getPermissions(Class<?> clazz) {
            return null;
        }
        public boolean implies(Permission p) {
            return false;
        }
    }

    private static class AccessControlImpl implements AccessControl {
        public AccessControl.Action access(java.security.CodeSource codeSouce, java.security.ProtectionDescriptor protections) {
            return AccessControl.Action.GRANT;
        }
    }

    public static void main(String[] args) throws Exception {
        File file = new File("sample.xml");
        if (!file.exists()) {
            throw new Exception("File not found!");
        }
        AccessControl acc = new AccessControlImpl();
        AccessController.setAccessControl(acc);
        FileInputStream fis = new FileInputStream(file);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(fis);
        // No more security-sensitive operations here.
    }
}