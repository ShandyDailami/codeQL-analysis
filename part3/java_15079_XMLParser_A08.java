import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

public class java_15079_XMLParser_A08 extends DefaultHandler {

    private String lastElement = "";
    private String lastNamespace = "";
    private boolean integrityFailure = false;

    public boolean isIntegrityFailure() {
        return integrityFailure;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastElement = qName;
        lastNamespace = uri;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (localName.equals(lastElement)) {
            integrityFailure = true;
        }
        lastElement = "";
        lastNamespace = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Do nothing
    }

    @Override
    public void endDocument() throws SAXException {
        // Do nothing
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        // Do nothing
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        // Do nothing
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        // Do nothing
    }
}