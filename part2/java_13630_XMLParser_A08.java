import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.DefaultHandler;

public class java_13630_XMLParser_A08 extends DefaultHandler {
    public java_13630_XMLParser_A08() {
        super();
    }

    public void parse(String xmlFile) {
        try {
            XMLReader xr = XMLReaderFactory.createXMLReader();
            xr.setContentHandler(this);
            xr.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startDocument() {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName)
            throws SAXException {
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

    @Override
    public void fatalError(String error) throws SAXException {
        System.out.println("Fatal error: " + error);
    }

    @Override
    public void warning(String warning) throws SAXException {
        System.out.println("Warning: " + warning);
    }

    public static void main(String[] args) {
        String xmlFile = "src/main/resources/sample.xml";
        new MyXMLParser().parse(xmlFile);
    }
}