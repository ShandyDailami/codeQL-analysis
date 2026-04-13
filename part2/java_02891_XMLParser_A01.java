import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

public class java_02891_XMLParser_A01 extends DefaultHandler {
    private StringBuilder data;

    public java_02891_XMLParser_A01() {
        this.data = new StringBuilder();
    }

    public void startDocument() throws SAXException {
        System.out.println("Start of XML document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of XML document");
    }

    public void startElement(String uri, String localName, String qName) throws SAXException {
        this.data.append("Start of element ");
        this.data.append(qName);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        this.data.append("End of element ");
        this.data.append(qName);
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        this.data.append(new String(ch, start, length));
    }

    public void fatalError(SAXException e) throws SAXException {
        System.out.println("Fatal Error: " + e.getMessage());
    }

    public void warning(SAXException e) throws SAXException {
        System.out.println("Warning: " + e.getMessage());
    }

    public static void main(String[] args) {
        UniqueVanillaXMLParser parser = new UniqueVanillaXMLParser();

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(parser);
            reader.parse("src/test.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }

        System.out.println(parser.getData().toString());
    }

    public StringBuilder getData() {
        return this.data;
    }
}