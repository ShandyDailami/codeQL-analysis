import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_06089_XMLParser_A08 extends DefaultHandler {

    // This method will be called when an element starts.
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start of element: " + qName);
    }

    // This method will be called when an element ends.
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of element: " + qName);
    }

    // This method will be called when an attribute ends.
    @Override
    public void endAttribute(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of attribute: " + qName);
    }

    // This method will be called when a character is encountered.
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    // This method will be called when an error occurs.
    @Override
    public void error(SAXException e) {
        System.out.println("SAXException: " + e.getMessage());
    }

    // This method will be called when a fatal error occurs.
    @Override
    public void fatalError(SAXException e) {
        System.out.println("Fatal SAXException: " + e.getMessage());
    }

    // This method will be called when a warning occurs.
    @Override
    public void warning(SAXException e) {
        System.out.println("Warning: " + e.getMessage());
    }

    public static void main(String[] args) {
        XmlParserHandler handler = new XmlParserHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, handler);
            parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("sample.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}