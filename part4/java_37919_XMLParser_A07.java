import java.net.URL;
import java.security.Permission;
import java.security.SecurityPermission;
import java.security.SecurityManager;
import java.security.UnresolvedPermission;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_37919_XMLParser_A07 {

    public static void main(String[] args) throws Exception {
        // Create a SAXParserFactory.
        SAXParserFactory spf = SAXParserFactory.newInstance();

        // Set the SecurityManager.
        SecurityManager sm = new SecurityManager() {
            @Override
            public void checkPermission(Permission perm) {
                if (perm instanceof UnresolvedPermission) {
                    throw new SecurityException("Unresolved permission: " + perm);
                }
            }

            @Override
            public void checkPermission(Permission perm, Object context) {
                if (perm instanceof UnresolvedPermission) {
                    throw new SecurityException("Unresolved permission: " + perm);
                }
            }
        };
        spf.setSecurityManager(sm);

        // Get the XML document.
        URL url = new URL("http://example.com/test.xml");

        // Create a new SAXParser.
        SAXParser saxParser = spf.newSAXParser();

        // Parse the XML document.
        saxParser.parse(url.toString(), new MyHandler());
    }
}

class MyHandler implements javax.xml.parsers.SAXHandler {
    @Override
    public void startDocument() throws javax.xml.parsers.SAXException {
        System.out.println("Start document.");
    }

    @Override
    public void endDocument() throws javax.xml.parsers.SAXException {
        System.out.println("End document.");
    }

    @Override
    public void startElement(String uri, String localName, String qName,
            javax.xml.parsers.Attributes attributes) throws javax.xml.parsers.SAXException {
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws javax.xml.parsers.SAXException {
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws javax.xml.parsers.SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }
}