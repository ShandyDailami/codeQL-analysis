import java.security.Permission;
import java.security.SecurityManager;
import java.util.HashSet;
import java.util.Set;

public class java_07320_XMLParser_A01 {

    public static void main(String[] args) {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            Set<Permission> perms = new HashSet<>();
            perms.add(new Permission("addXMLContent"));
            perms.add(new Permission("modifyXMLContent"));
            perms.add(new Permission("removeXMLContent"));
            sm.checkPermission(perms);
        }
        
        // Create an XMLDocument object
        XMLDocument doc = new XMLDocument();

        // Add content to the document
        doc.addContent("<root></root>");

        // Print the document to the console
        doc.print();
    }

    // Inner class XMLDocument
    static class XMLDocument {
        private String content;

        public void addContent(String content) {
            // BrokenAccessControl: Modifying content is not allowed in real-world applications
            // This is a security-sensitive operation, not allowed in real-world applications
            // This is a placeholder for the real-world operation
            this.content = content;
        }

        public void print() {
            System.out.println(this.content);
        }
    }
}