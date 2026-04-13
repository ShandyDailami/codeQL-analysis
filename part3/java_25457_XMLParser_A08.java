import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_25457_XMLParser_A08 {
    private Stack<String> stack = new Stack<>();

    private class SAXHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            stack.push(qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            if (isSecuritySensitive(stack.pop())) {
                System.out.println("Security-sensitive operation detected in: " + qName);
            }
        }
    }

    private boolean isSecuritySensitive(String elementName) {
        // Implement your own logic here for security-sensitive operations
        // For simplicity, let's assume all elements named starting with 'A' are security-sensitive
        return elementName.charAt(0) == 'A';
    }

    public void parse(String xml) {
        SAXHandler handler = new SAXHandler();
        org.xml.sax.SAXParserFactory factory = org.xml.sax.SAXParserFactory.newInstance();
        try {
            org.xml.sax.SAXParser parser = factory.newSAXParser(null, handler);
            parser.parse(xml.getBytes("UTF-8"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}