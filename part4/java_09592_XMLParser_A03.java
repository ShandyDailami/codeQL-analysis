import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_09592_XMLParser_A03 {

    public static void main(String[] args) {
        String xml = "<note>\n" +
                "    <to>Tove</to>\n" +
                "    <from>Jani</from>\n" +
                "    <heading>Reminder</heading>\n" +
                "    <body>Don't forget me this weekend!</body>\n" +
                "</note>";

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(null);

        SAXHandler saxHandler = new SAXHandler();
        saxParser.parse(xml.getBytes(), saxHandler);

        System.out.println("To: " + saxHandler.getTo());
        System.out.println("From: " + saxHandler.getFrom());
        System.out.println("Heading: " + saxHandler.getHeading());
        System.out.println("Body: " + saxHandler.getBody());
    }

    static class SAXHandler extends DefaultHandler {
        private String to;
        private String from;
        private String heading;
        private String body;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("to")) {
                to = attributes.getValue("0");
            } else if (qName.equals("from")) {
                from = attributes.getValue("0");
            } else if (qName.equals("heading")) {
                heading = attributes.getValue("0");
            } else if (qName.equals("body")) {
                body = attributes.getValue("0");
            }
        }

        public String getTo() {
            return to;
        }

        public String getFrom() {
            return from;
        }

        public String getHeading() {
            return heading;
        }

        public String getBody() {
            return body;
        }
    }
}