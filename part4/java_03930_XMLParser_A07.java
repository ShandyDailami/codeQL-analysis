import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_03930_XMLParser_A07 {

    // SAX parser implementation
    static class AuthFailureHandler extends DefaultHandler {
        private boolean isAuthFailure = false;
        private boolean isAuthTag = false;

        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("AuthFailure")) {
                isAuthFailure = true;
            }

            if (qName.equalsIgnoreCase("AuthTag")) {
                isAuthTag = true;
            }
        }

        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            if (qName.equalsIgnoreCase("AuthFailure")) {
                isAuthFailure = false;
            }

            if (qName.equalsIgnoreCase("AuthTag")) {
                isAuthTag = false;
           
                if (isAuthFailure) {
                    System.out.println("Authentication failure detected!");
                } else if (isAuthTag) {
                    System.out.println("Authentication tag found!");
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // Create a SAX parser
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        // Parse the XML document
        parser.parse("example.xml", new AuthFailureHandler());
    }
}