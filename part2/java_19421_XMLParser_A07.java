import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_19421_XMLParser_A07 extends DefaultHandler {
    private String curTag;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.print("Start of " + qName);
        curTag = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of " + qName);
        curTag = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (curTag != null) {
            System.out.println("Text: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();
            XMLParserLegacy handler = new XMLParserLegacy();
            parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("sample.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}