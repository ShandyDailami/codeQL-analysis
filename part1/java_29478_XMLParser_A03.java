import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_29478_XMLParser_A03 extends DefaultHandler {

    // Check if the XML is well-formed
    private boolean parsingWellFormed = true;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        // Start parsing
        parsingWellFormed = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        // End parsing
        parsingWellFormed = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        // Check if the XML is well-formed
        if (!parsingWellFormed) {
            throw new SAXException("XML not well-formed");
        }
    }

    @Override
    public void fatalError(String error) throws SAXException {

        // Check if the XML is well-formed
        if (parsingWellFormed) {
            throw new SAXException("XML not well-formed: " + error);
        }
    }
}