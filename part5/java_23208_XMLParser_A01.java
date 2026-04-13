import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_23208_XMLParser_A01 extends DefaultHandler {

    public static void main(String[] args) {
        String xml = "<person><name>John</name><age>30</age></person>";
        new MyXMLParser().parse(xml);
    }

    private void parse(String xml) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new MyXMLParser());
            parser.parse(new InputSource(new StringReader(xml)));
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
}