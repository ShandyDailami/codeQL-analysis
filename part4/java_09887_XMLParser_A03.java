import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_09887_XMLParser_A03 {

    public static void main(String[] args) {
        String xml = "<note>\n" +
                "<to>Tove</to>\n" +
                "<from>Jani</from>\n" +
                "<heading>Reminder</heading>\n" +
                "<body>Don't forget me this weekend!</body>\n" +
                "</note>";

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new XMLHandler());

            parser.parse(new StringReader(xml));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class XMLHandler extends DefaultHandler {
        boolean bTo = false;
        boolean bFrom = false;
        boolean bHeading = false;
        boolean bBody = false;

        String to;
        String from;
        String heading;
        String body;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equals("to")) bTo = true;
            if (qName.equals("from")) bFrom = true;
            if (qName.equals("heading")) bHeading = true;
            if (qName.equals("body")) bBody = true;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("to")) bTo = false;
            if (qName.equals("from")) bFrom = false;
            if (qName.equals("heading")) bHeading = false;
            if (qName.equals("body")) bBody = false;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bTo) {
                to = new String(ch, start, length);
            } else if (bFrom) {
                from = new String(ch, start, length);
            } else if (bHeading) {
                heading = new String(ch, start, length);
            } else if (bBody) {
                body = new String(ch, start, length);
            }
        }

        @Override
        public void endDocument() {
            System.out.println("To: " + to);
            System.out.println("From: " + from);
            System.out.println("Heading: " + heading);
            System.out.println("Body: " + body);
        }
    }
}