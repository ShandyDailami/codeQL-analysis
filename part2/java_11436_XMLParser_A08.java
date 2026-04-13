import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

public class java_11436_XMLParser_A08 extends DefaultHandler {

    private boolean integrityFailureFound = false;

    public void startDocument() throws SAXException {
        // Do nothing in this implementation
    }

    public void endDocument() throws SAXException {
        // Do nothing in this implementation
    }

    public void startElement(String uri, String localName, String qName) throws SAXException {
        if ("A08_IntegrityFailure".equals(localName)) {
            integrityFailureFound = true;
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Do nothing in this implementation
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        // Do nothing in this implementation
    }

    public static void parseXML(String filename) throws Exception {
        XMLReader xr = XMLReaderFactory.createXMLReader();
        xr.setContentHandler(new MySAXHandler());
        xr.parse(filename);
    }

    public static void main(String[] args) {
        try {
            parseXML("sample.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}