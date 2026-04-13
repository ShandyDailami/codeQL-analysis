import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_08363_XMLParser_A07 extends DefaultHandler {

    public static void main(String[] args) {
        String xml = "<note><to>Tove</to><from>Jani</from><heading>Reminder</heading><body>Don't forget me this weekend!</body></note>";
        XMLParser parser = new XMLParser();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(new InputSource(new StringReader(xml)));
            saxParser.parse(new InputSource(new StringReader(xml)), parser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length);
        System.out.println("Content: " + content);
    }
}