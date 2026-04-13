import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_05636_XMLParser_A01 {

    public static void main(String[] args) {
        String xml = "<note>" +
                "<to>Tove</to>" +
                "<from>Jani</from>" +
                "<message>Remark about the meeting.</message>" +
                "</note>";

        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            MyHandler handler = new MyHandler();
            saxParser.parse(new StringReader(xml), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        boolean bTo = false;
        boolean bFrom = false;
        boolean bMessage = false;
        StringBuilder to;
        StringBuilder from;
        StringBuilder message;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("to")) {
                bTo = true;
                to = new StringBuilder();
            } else if (qName.equalsIgnoreCase("from")) {
                bFrom = true;
                from = new StringBuilder();
            } else if (qName.equalsIgnoreCase("message")) {
                bMessage = true;
                message = new StringBuilder();
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("to")) {
                System.out.println("To: " + to);
                bTo = false;
            } else if (qName.equalsIgnoreCase("from")) {
                System.out.println("From: " + from);
                bFrom = false;
            } else if (qName.equalsIgnoreCase("message")) {
                System.out.println("Message: " + message);
                bMessage = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bTo) {
                to.append(new String(ch, start, length));
            } else if (bFrom) {
                from.append(new String(ch, start, length));
            } else if (bMessage) {
                message.append(new String(ch, start, length));
            }
        }
    }
}