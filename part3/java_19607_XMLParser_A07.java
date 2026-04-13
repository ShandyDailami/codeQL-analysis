import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_19607_XMLParser_A07 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(XmlParser.class.getResourceAsStream("/data.xml"), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        private boolean bAuthFailure = false;
        private boolean bSecurityToken = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (localName.equals("securityToken")) {
                bSecurityToken = true;
            } else if (localName.equals("authFailure")) {
                bAuthFailure = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (localName.equals("securityToken")) {
                bSecurityToken = false;
            } else if (localName.equals("authFailure")) {
                bAuthFailure = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bSecurityToken) {
                // Handle the security token here
                System.out.println("Found a security token!");
            } else if (bAuthFailure) {
                // Handle the auth failure here
                System.out.println("Found an auth failure!");
            }
        }
    }
}