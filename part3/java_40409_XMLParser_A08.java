import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.LinkedList;
import java.util.List;

public class java_40409_XMLParser_A08 extends DefaultHandler {

    private List<String> integrityFailureElements = new LinkedList<>();

    @Override
    public void startDocument() throws SAXException {
        integrityFailureElements.clear();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("integrityFailure")) {
            integrityFailureElements.add(qName);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Do nothing
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Do nothing
    }

    public List<String> getIntegrityFailureElements() {
        return integrityFailureElements;
    }
}