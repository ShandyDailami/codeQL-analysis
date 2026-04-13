import java.security.Permission;
import java.security.SecurityException;
import java.util.Stack;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_29190_XMLParser_A03 {

    private static class MySAXHandler extends DefaultHandler {
        private Stack<String> stack = new Stack<>();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            // This method is empty for brevity
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            String tagName = qName;

            // Check for security violation
            Permission permission = new Permission("xml.parse");
            try {
                SecurityManager sm = System.getSecurityManager();
                if (sm != null) {
                    sm.checkPermission(permission);
                }
            } catch (SecurityException e) {
                System.out.println("Security violation: attempted to parse XML using " + tagName);
                return;
            }

            // Do something with the parsed XML
            System.out.println("Parsed XML tag: " + tagName);
        }
    }

    public static void main(String[] args) {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser(null);
        sp.setContentHandler(new MySAXHandler());
        sp.parse("src/test.xml", null);
    }
}