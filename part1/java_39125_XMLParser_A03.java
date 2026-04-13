import javax.xml.parsers.XMLParser;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_39125_XMLParser_A03 {
    public static void main(String[] args) {
        String xml = "<note>" +
                "<to>Tove</to>" +
                "<from>Jani</from>" +
                "<heading>Reminder</heading>" +
                "<body>Don't forget me this weekend!</body>" +
                "</note>";

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null);

            MyHandler handler = new MyHandler();
            saxParser.parse(new InputSource(new StringReader(xml)), handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean toFound = false;
    private boolean fromFound = false;
    private boolean headingFound = false;
    private boolean bodyFound = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("to")) {
            toFound = true;
        } else if (qName.equals("from")) {
            fromFound = true;
        } else if (qName.equals("heading")) {
            headingFound = true;
        } else if (qName.equals("body")) {
            bodyFound = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("to")) {
            toFound = false;
        } else if (qName.equals("from")) {
            fromFound = false;
        } else if (qName.equals("heading")) {
            headingFound = false;
        } else if (qName.equals("body")) {
            bodyFound = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (toFound) {
            System.out.println("To: " + new String(ch, start, length));
        } else if (fromFound) {
            System.out.println("From: " + new String(ch, start, length));
        } else if (headingFound) {
            System.out.println("Heading: " + new String(ch, start, length));
        } else if (bodyFound) {
            System.out.println("Body: " + new String(ch, start, length));
        }
    }
}