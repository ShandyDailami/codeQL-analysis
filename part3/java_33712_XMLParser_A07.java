import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_33712_XMLParser_A07 {

    class MyHandler extends DefaultHandler {
        boolean bUsername = false;
        boolean bPassword = false;
        String username = null;
        String password = null;

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
            if (qName.equalsIgnoreCase("username")) {
                bUsername = true;
            } else if (qName.equalsIgnoreCase("password")) {
                bPassword = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("username")) {
                bUsername = false;
            } else if (qName.equalsIgnoreCase("password")) {
                bPassword = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bUsername) {
                username = new String(ch, start, length);
            } else if (bPassword) {
                password = new String(ch, start, length);
            }
        }

        @Override
        public void fatalError(SAXException e) throws SAXException {
            System.out.println("Fatal Error: " + e.getMessage());
        }

        @Override
        public void warning(SAXException e) throws SAXException {
            System.out.println("Warning: " + e.getMessage());
        }
    }

    public void parse(String file) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new MyHandler());
        parser.parse(file);

        if (username != null && password != null) {
            // secure sensitive operations related to A07_AuthFailure
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
        }
    }

    public static void main(String[] args) {
        try {
            new MyXMLParser().parse("sample.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}