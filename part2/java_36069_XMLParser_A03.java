import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_36069_XMLParser_A03 extends DefaultHandler {

    public static void main(String[] args) {
        String xml = "<note><to>Tove</to><from>Jani</from><heading>Reminder</heading><body>Don't forget me this weekend!</body></note>";
        XmlParserExample handler = new XmlParserExample();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, handler);
            parser.parse(new InputSource(new StringReader(xml)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // This method is empty and is used to avoid a warning.
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // This method is empty and is used to avoid a warning.
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // This method is empty and is used to avoid a warning.
    }
}