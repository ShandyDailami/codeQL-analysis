import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_13692_XMLParser_A07 extends DefaultHandler {
    public static void main(String[] args) {
        String xml = "<root><element>Content</element></root>"; // replace with your XML
        new MyXMLParser().parse(xml);
    }

    public void parse(String xml) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new SAXSource(new StringReader(xml)));
            parser.setProperty("http://xml.org/sax/nonamespace", "true");
            parser.setProperty("http://xml.org/sax/namespaces", "false");
            parser.parse(new InputSource(new StringReader(xml)), this);
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

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        System.out.println("Fatal error: " + e.getMessage());
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        System.out.println("Warning: " + e.getMessage());
    }
}