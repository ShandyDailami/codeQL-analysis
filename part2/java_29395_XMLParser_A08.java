import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_29395_XMLParser_A08 {

    // The SAXParser is a simple API for parsing XML documents.
    private SAXParserFactory factory;

    // The DefaultHandler is a simple implementation of the SAX API.
    private DefaultHandler handler;

    public java_29395_XMLParser_A08() {
        factory = SAXParserFactory.newInstance();
        handler = new DefaultHandler();
    }

    public void parse(String filename) {
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(filename, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // The DefaultHandler needs to implement the following methods.

    @Override
    public void startDocument(String uri, String localName, String version)
            throws SAXException {
        System.out.println("Start document: " + localName);
    }

    @Override
    public void endDocument(String uri, String localName, String version)
            throws SAXException {
        System.out.println("End document: " + localName);
    }

    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }
}