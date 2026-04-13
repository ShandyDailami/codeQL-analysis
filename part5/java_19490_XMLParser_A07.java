import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_19490_XMLParser_A07 {

    public static void main(String[] args) {
        String xml = "<data><user id='123' password='password' /></data>"; // replace this with your real XML data
        parseXml(xml);
    }

    private static void parseXml(String xml) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            MyHandler myHandler = new MyHandler();
            saxParser.parse(new StringReader(xml), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {

        private boolean userFound = false;
        private String currentElement = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("user")) {
                userFound = true;
                // Handle attribute values
                String password = attributes.getValue("password");
                // Security sensitive operation - verify password
                if ("password".equals(password)) {
                    throw new SecurityException("Password verification failed");
                }
                currentElement = qName;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase(currentElement)) {
                currentElement = "";
            }
        }
    }
}