import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_10471_XMLParser_A07 extends DefaultHandler {

    public static void main(String[] args) {
        String xml = "<note><to>Tove</to><from>Jani</from><message>Varmår</message></note>";
        MyXMLParser parser = new MyXMLParser();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser(null, parser);
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
        System.out.println("Characters: " + new String(ch, start, length));
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        System.out.println("Start prefix mapping: " + prefix + " " + uri);
    }

    @Override
    public void endPrefixMapping(String prefix, String uri) throws SAXException {
        System.out.println("End prefix mapping: " + prefix + " " + uri);
    }
}