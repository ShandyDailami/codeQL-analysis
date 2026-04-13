import java.io.File;
import java.io.FileInputStream;
import java.security.AccessControlException;
import java.security.AccessDeniedException;
import java.security.Permission;
import java.security.SecurityManager;
import java.security.PrivilegedAction;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_14985_XMLParser_A01 {

    // SecurityManager that allows reading the file
    private SecurityManager securityManager = new SecurityManager() {
        @Override
        public void checkPermission(Permission perm) throws AccessControlException {
            // All permissions are allowed
        }

        @Override
        public void checkAccess(Runnable action) throws AccessDeniedException {
            action.run();
        }
    };

    public void parseFile(String fileName) throws Exception {
        // Construct a SAXParser from the factory
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(securityManager);

        // Set the content handler
        parser.setContentHandler(new ContentHandler());

        // Parse the XML file
        parser.parse(new File(fileName));
    }

    private class ContentHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            // Handle start element
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // Handle end element
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // Handle characters
        }
    }

    public static void main(String[] args) {
        try {
            new BrokenAccessControlXMLParser().parseFile("sample.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}