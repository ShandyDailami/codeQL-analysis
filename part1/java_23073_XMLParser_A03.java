import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.StringReader;
import java.security.SecureRandom;

public class java_23073_XMLParser_A03 {

    // Insecure way of generating random strings
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static void main(String[] args) throws Exception {
        SecureRandom r = new SecureRandom();
        String randomString = nextSecureString(10, r);

        String xmlContent = "<note><to>Tove</to><from>Jani</from><heading>Reminder</heading><body>Don't forget about the meeting at home.</body></note>";

        // Step 1: Parse using DOM
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new InputSource(new StringReader(xmlContent)));
        System.out.println("XML Parsed using DOM");

        // Step 2: Parse using SAX
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(null);
        SAXHandler saxHandler = new SAXHandler();
        saxParser.parse(new InputSource(new StringReader(xmlContent)), saxHandler);
        System.out.println("XML Parsed using SAX");

        // Step 3: Insecure way of generating random string
        System.out.println("Random String (Not using any library): " + randomString);
    }

    private static String nextSecureString(int size, SecureRandom random) {
        if (size < 1) {
            throw new IllegalArgumentException("size < 1: " + size);
        }
        StringBuilder sb = new StringBuilder(size);
        for (int i = size; i > 0; i--) {
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }

    static class SAXHandler implements org.xml.sax.helpers.DefaultHandler {

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
            System.out.println("Start element: " + localName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End element: " + localName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}