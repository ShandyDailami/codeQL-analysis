import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_39026_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null);
            MyHandler handler = new MyHandler();
            
            parser.parse("src/main/resources/example.xml", handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private boolean integrityFailure = false;
        
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (localName.equals("node")) {
                // Check for integrity failure
                String integrity = attributes.getValue("integrity");
                if (integrity != null && integrity.equals("failure")) {
                    integrityFailure = true;
                }
            }
        }
        
        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // Check for integrity failure
            if (localName.equals("node")) {
                if (integrityFailure) {
                    System.out.println("Integrity failure detected in the XML document!");
                }
            }
        }
    }
}