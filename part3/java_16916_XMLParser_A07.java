import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_16916_XMLParser_A07 {
    private static final String XML_DOC = "src/main/resources/authfailure.xml"; // path to your XML file

    public static void main(String[] args) {
        XMLReader xmlReader = SAXParser.newInstance().getReader();
        xmlReader.setContentHandler(new MyContentHandler());
        xmlReader.parse(new File(XML_DOC));
    }

    static class MyContentHandler extends DefaultHandler {
        private boolean isAuthFailure = false;
        private boolean isAuthToken = false;

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("AuthFailure")) {
                isAuthFailure = true;
            } else if (qName.equalsIgnoreCase("AuthToken")) {
                isAuthToken = true;
            } else {
                if (isAuthFailure && isAuthToken) {
                    // start security-sensitive operation related to AuthFailure
                    System.out.println("Security sensitive operation related to AuthFailure has started");
                    // end security-sensitive operation
                    isAuthFailure = false;
                    isAuthToken = false;
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("AuthFailure")) {
                isAuthFailure = false;
            } else if (qName.equalsIgnoreCase("AuthToken")) {
                isAuthToken = false;
            }
        }

        @Override
        public void characters(char[] chars, int start, int length) throws SAXException {
            if (isAuthFailure && isAuthToken) {
                String value = new String(chars, start, length);
                System.out.println("AuthToken: " + value);
            }
        }
    }
}