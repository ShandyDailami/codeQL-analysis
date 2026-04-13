import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_11662_XMLParser_A01 {
    
    public static class MyHandler extends DefaultHandler {
        
        private boolean accessControl = false;
        
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("accessControl")) {
                accessControl = true;
            }
        }
        
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("accessControl")) {
                accessControl = false;
            }
        }
        
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (accessControl) {
                // This is where we can handle the security-sensitive operation
                // For example, we could check if the password is in the document
                String password = new String(ch, start, length);
                if (password.equals("secret")) {
                    System.out.println("Access denied!");
                }
            }
        }
    }
    
    public static void main(String[] args) {
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxFactory.newSAXParser(null, new MyHandler());
            saxParser.parse("src/main/resources/example.xml", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}