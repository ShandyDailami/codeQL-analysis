import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_10167_XMLParser_A07 {

    public static void main(String[] args) {
        String xmlData = "<note>\n" +
                "<to>Tove</to>\n" +
                "<from>Jani</from>\n" +
                "<heading>Reminder</heading>\n" +
                "<body>Don't forget me this weekend!</body>\n" +
                "</note>";
        parse(xmlData);
    }

    public static void parse(String xmlData) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new SAXHandler(null));
            parser.parse(new StringReader(xmlData));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class SAXHandler extends DefaultHandler {
        private boolean to;
        private boolean from;
        private boolean heading;
        private boolean body;

        @Override
        public void startDocument() throws SAXException {
            to = true;
            from = true;
            heading = true;
            body = true;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("to")) {
                to = true;
            } else if (qName.equals("from")) {
                from = true;
            } else if (qName.equals("heading")) {
                heading = true;
            } else if (qName.equals("body")) {
                body = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("to")) {
                to = false;
            } else if (qName.equals("from")) {
                from = false;
            } else if (qName.equals("heading")) {
                heading = false;
            } else if (qName.equals("body")) {
                body = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (to) {
                System.out.println("To: " + new String(ch, start, length));
            } else if (from) {
                System.out.println("From: " + new String(ch, start, length));
            } else if (heading) {
                System.out.println("Heading: " + new String(ch, start, length));
            } else if (body) {
                System.out.println("Body: " + new String(ch, start, length));
            }
        }
    }
}