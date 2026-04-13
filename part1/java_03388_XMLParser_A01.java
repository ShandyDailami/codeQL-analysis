import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_03388_XMLParser_A01 {
    public static void main(String[] args) {
        String xml = "<note>\n" +
                "  <to>Tove</to>\n" +
                "  <from>Jani</from>\n" +
                "  <heading>Reminder</heading>\n" +
                "  <body>Don't forget me this weekend!</body>\n" +
                "</note>";

        parse(xml);
    }

    static void parse(String xml) {
        DefaultHandler handler = new DefaultHandler() {
            boolean inTo = false;
            boolean inFrom = false;
            boolean inHeading = false;
            boolean inBody = false;

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if (qName.equals("to")) inTo = true;
                if (qName.equals("from")) inFrom = true;
                if (qName.equals("heading")) inHeading = true;
                if (qName.equals("body")) inBody = true;
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                if (qName.equals("to")) inTo = false;
                if (qName.equals("from")) inFrom = false;
                if (qName.equals("heading")) inHeading = false;
                if (qName.equals("body")) inBody = false;
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                if (inTo) System.out.println("To: " + new String(ch, start, length));
                if (inFrom) System.out.println("From: " + new String(ch, start, length));
                if (inHeading) System.out.println("Heading: " + new String(ch, start, length));
                if (inBody) System.out.println("Body: " + new String(ch, start, length));
            }
        };

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.parse(new InputSource(new StringReader(xml)), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}