import java.security.Permission;
import java.security.SecurityPermission;
import java.util.HashSet;
import java.util.Set;

public class java_07343_XMLParser_A07 extends SecurityManager {

    private static final Set<Permission> permissions = new HashSet<Permission>();

    static {
        permissions.add(new SecurityPermission("getClass"));
    }

    @Override
    public void checkPermission(Permission permission) {
        if (permissions.contains(permission)) {
            throw new SecurityException("Access to security sensitive operation denied.");
        }
    }

    @Override
    public void checkPermissions() {
        //Nothing to do
    }
}

import java.util.logging.Logger;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class XmlParser {

    private static final Logger logger = Logger.getLogger(XmlParser.class.getName());

    public static void main(String[] args) {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser saxParser = spf.newSAXParser();

        saxParser.parse("src/resources/data.xml", new MyHandler());
    }

    static class MyHandler extends javax.xml.parsers.SAXHandler {

        @Override
        public void startElement(String uri, String localName, String qName, javax.xml.parsers.Attributes attributes) {
            logger.info("Start Element: " + qName);

            // Accessing sensitive information here
            String username = attributes.getValue("username");
            String password = attributes.getValue("password");

            logger.info("Username: " + username);
            logger.info("Password: " + password);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            logger.info("End Element: " + qName);
        }
    }
}