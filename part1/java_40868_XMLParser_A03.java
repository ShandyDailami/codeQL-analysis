import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_40868_XMLParser_A03 {

    public static void main(String[] args) {
        String xml = "<note>" +
                "<to>Tove</to>" +
                "<from>Jani</from>" +
                "<heading>Reminder</heading>" +
                "<body>Don't forget me this weekend!</body>" +
                "</note>";

        parse(xml);
    }

    private static void parse(String xml) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new InputSource(new StringReader(xml)), null);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        boolean bTo = false;
        boolean bFrom = false;
        boolean bHeading = false;
        boolean bBody = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("to")) bTo = true;
            if (qName.equalsIgnoreCase("from")) bFrom = true;
            if (qName.equalsIgnoreCase("heading")) bHeading = true;
            if (qName.equalsIgnoreCase("body")) bBody = true;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("to")) bTo = false;
            if (qName.equalsIgnoreCase("from")) bFrom = false;
            if (qName.equalsIgnoreCase("heading")) bHeading = false;
            if (qName.equalsIgnoreCase("body")) bBody = false;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bTo) System.out.println("To: " + new String(ch, start, length));
            if (bFrom) System.out.println("From: " + new String(ch, start, length));
            if (bHeading) System.out.println("Heading: " + new String(ch, start, length));
            if (bBody) System.out.println("Body: " + new String(ch, start, length));
        }
    }
}