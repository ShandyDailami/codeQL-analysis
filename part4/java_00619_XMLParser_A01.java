import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_00619_XMLParser_A01 extends DefaultHandler {
    public static void main(String[] args) {
        String xml = "<root><element>content</element></root>";
        XMLParser parser = new XMLParser();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser(null);
            saxParser.parse(new InputSource(new StringReader(xml)), parser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        System.out.println("Characters: " + new String(ch, start, length));
    }
}