import java.io.File;
import java.security.Permission;
import java.security.SecurityManager;
import java.util.Iterator;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_39259_XMLParser_A03 extends DefaultHandler {
    private StringBuilder stringBuilder;

    // Define a Permission object to be used by the SecurityManager
    private class Permission implements Permission {
        public String getName() {
            return null;
        }

        public String getActions() {
            return null;
        }

        public void grant(String permission) throws SecurityException {
            // No-op
        }

        public void deny(String permission) throws SecurityException {
            // No-op
        }
    }

    public void parse(String filename) throws Exception {
        // Create a SecurityManager and add our Permission
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.setPermission(new Permission("fileIo"));
        }

        // Create a SAXParserFactory and use it to create a SAXParser
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser saxParser = spf.newSAXParser(null);

        // Parse the file
        saxParser.parse(new File(filename), this);
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        stringBuilder.append("Start of element: " + qName + "\n");
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        stringBuilder.append("End of element: " + qName + "\n");
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        stringBuilder.append(new String(ch, start, length));
    }

    public static void main(String[] args) throws Exception {
        LegacySecurityManagerSAXParser xmlParser = new LegacySecurityManagerSAXParser();
        xmlParser.stringBuilder = new StringBuilder();
        xmlParser.parse("test.xml");
        System.out.println(xmlParser.stringBuilder.toString());
    }
}