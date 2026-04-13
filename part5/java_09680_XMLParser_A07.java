import java.security.Permission;
import java.security.SecurityException;

public class java_09680_XMLParser_A07 implements PermissionChecker {
    private SecurityManager securityManager;

    public java_09680_XMLParser_A07(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    @Override
    public boolean checkPermission(Permission permission) throws SecurityException {
        return securityManager.checkPermission(permission);
    }
}

interface PermissionChecker {
    boolean checkPermission(Permission permission) throws SecurityException;
}

public class XMLParser {
    private PermissionChecker permissionChecker;

    public java_09680_XMLParser_A07(PermissionChecker permissionChecker) {
        this.permissionChecker = permissionChecker;
    }

    public void parse(String fileName) throws Exception {
        try {
            permissionChecker.checkPermission(new java.security.Permission("auth"));
        } catch (SecurityException e) {
            throw new Exception("Permission denied: Auth failure", e);
        }

        java.util.logging.FileHandler fileHandler = new java.util.logging.FileHandler("log.xml");
        java.util.logging.Logger logger = java.util.logging.Logger.getLogger(java.util.logging.Logger.getLogger(XMLParser.class.getName()).getName());

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        XMLHandler xmlHandler = new XMLHandler();

        saxParser.parse(fileName, xmlHandler);

        logger.info("Parsed XML file successfully");
    }

    class XMLHandler extends DefaultHandler {
        @Override
        public void startDocument() throws SAXException {
            // Do nothing
        }

        @Override
        public void endDocument() throws SAXException {
            // Do nothing
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            // Do nothing
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // Do nothing
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // Do nothing
        }
    }
}