import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_13653_XMLParser_A03 {
    // Create a SAX parser
    SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

    // A custom SAX handler
    class MyHandler extends DefaultHandler {
        private String lastElement;
        private String lastQuotedString;
        private String lastDQuotedString;

        @Override
        public void startElement(String uri, String localName, String qName,
                                 Attributes attributes) throws SAXException {
            // If the element name is "injection", it is a security risk
            if (qName.equals("injection")) {
                System.out.println("Security risk detected: injection attempt detected");
            }
            lastElement = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            if (qName.equals(lastElement)) {
                System.out.println("Successfully parsed XML");
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String str = new String(ch, start, length);
            if (str.trim().isEmpty()) {
                return;
            }
            if (lastElement.equals("message")) {
                System.out.println("Message: " + str);
            } else if (lastElement.equals("name")) {
                System.out.println("Name: " + str);
            }
            lastElement = null;
        }
    }

    public void parse(String fileName) throws Exception {
        SAXParser saxParser = saxParserFactory.newSAXParser();
        saxParser.parse(fileName, new MyHandler());
    }

    public static void main(String[] args) throws Exception {
        XmlSaxParser parser = new XmlSaxParser();
        parser.parse("sample.xml");
    }
}