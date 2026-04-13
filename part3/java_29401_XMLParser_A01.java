import java.io.File;
import java.io.FileInputStream;
import java.security.AccessControlException;
import java.security.AccessControlListener;
import java.security.AccessControlContext;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_29401_XMLParser_A01 extends DefaultHandler {

    private SAXParser saxParser;
    private FileInputStream fis;

    private static class SecureContext extends AccessControlContext {
        private List<AccessControlListener> listeners;

        SecureContext(List<AccessControlListener> listeners) {
            this.listeners = listeners;
        }

        @Override
        public void checkPermission(AccessControlContext context, Object permission)
                throws AccessControlException {
            for (AccessControlListener listener : listeners) {
                listener.checkPermission(context, permission);
            }
        }

        @Override
        public void checkActions(AccessControlContext context, String actions)
                throws AccessControlException {
            for (AccessControlListener listener : listeners) {
                listener.checkActions(context, actions);
            }
        }
    }

    public java_29401_XMLParser_A01() throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        saxParser = factory.newSAXParser(null, this);

        File file = new File("input.xml");
        fis = new FileInputStream(file);
    }

    public void parse() throws Exception {
        saxParser.parse(fis, new SecureContext(new AccessControlListener[] { new AccessControlListener() {
            @Override
            public void checkPermission(AccessControlContext context, Object permission)
                    throws AccessControlException {
                // Do something
            }

            @Override
            public void checkActions(AccessControlContext context, String actions)
                    throws AccessControlException {
                // Do something
            }
        } }));
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        // Do something
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Do something
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        // Do something
    }

    public static void main(String[] args) {
        try {
            new SecureXMLParser().parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}