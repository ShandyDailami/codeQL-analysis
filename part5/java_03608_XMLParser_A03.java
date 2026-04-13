import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_03608_XMLParser_A03 extends DefaultHandler {
    private boolean parsingEnd = false;
    private boolean bInsideElement = false;
    private StringBuilder currentElement;

    public static void main(String[] args) {
        String xml = "<root><item>Injection is dangerous.</item><item>You can injure others.</item></root>";
        MyXMLHandler handler = new MyXMLHandler();
        handler.parse(new StringReader(xml));
    }

    public void parse(StringReader reader) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(new InputSource(reader));
            parser.setProperty( "http://xml.org/sax/properties/external-generalized-element", Boolean.TRUE );
            parser.setProperty( "http://xml.org/sax/properties/external-preferred-length-element", Boolean.TRUE );
            parser.setProperty( "http://xml.org/sax/properties/external-element", Boolean.TRUE );
            parser.parse(new InputSource(new StringReader(xml)), this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startDocument() {
        parsingEnd = false;
        currentElement = new StringBuilder();
    }

    @Override
    public void endDocument() {
        parsingEnd = true;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        bInsideElement = true;
        currentElement.setLength(0);
        currentElement.append(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        bInsideElement = false;
        currentElement.append("/").append(qName);
        if (parsingEnd) {
            System.out.println(currentElement.toString());
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (bInsideElement) {
            currentElement.append(new String(ch, start, length));
        }
    }
}