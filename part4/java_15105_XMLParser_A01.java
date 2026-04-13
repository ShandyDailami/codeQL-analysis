import java.security.Permission;
import java.security.SecurityManager;
import java.util.HashSet;
import java.util.Set;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_15105_XMLParser_A01 {

    private static class SecurityManager extends java.security.SecurityManager {
        private Set<Permission> permissions = new HashSet<>();

        public java_15105_XMLParser_A01() {
            // Add permissions for the purpose of this example
            this.permissions.add(new Permission("accessElement"));
        }

        public Set<Permission> getPermissions() {
            return permissions;
        }
    }

    public static void main(String[] args) throws Exception {
        SecurityManager securityManager = new SecurityManager();

        // Create a SAXParserFactory
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        // Create a SAXParser with the security manager
        SAXParser saxParser = saxParserFactory.newSAXParser(securityManager);

        // Parse the XML file
        saxParser.parse("src/main/resources/legacy_file.xml", new MyHandler());
    }

    private static class MyHandler extends javax.xml.parsers.SAXHandler {

        @Override
        public void startElement(String uri, String localName, String qName, javax.xml.parsers.Attributes attributes) throws javax.xml.parsers.SAXException {
            // Check if the caller has access to this element
            if (!securityManager.getPermissions().contains("accessElement")) {
                throw new SecurityException("Unauthorized access to element: " + qName);
            }

            // Continue parsing
            super.startElement(uri, localName, qName, attributes);
        }
    }
}