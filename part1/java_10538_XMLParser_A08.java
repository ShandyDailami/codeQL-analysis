import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class java_10538_XMLParser_A08 extends DefaultHandler {

    private List<String> names;
    private StringBuffer buffer;
    private String currentElement;
    private boolean integrityFailureFound;

    public java_10538_XMLParser_A08() {
        names = new ArrayList<>();
        buffer = new StringBuffer();
        integrityFailureFound = false;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        buffer.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (currentElement.equals("Name")) {
            if (buffer.length() == 0) {
                integrityFailureFound = true;
            } else {
                names.add(buffer.toString());
            }
        } else {
            throw new SAXException("Unexpected element: " + qName);
        }
        currentElement = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement != null) {
            buffer.append(ch, start, length);
        }
    }

    @Override
    public void error(SAXException e) {
        integrityFailureFound = true;
    }

    @Override
    public void fatalError(SAXException e) {
        integrityFailureFound = true;
    }

    @Override
    public void warning(SAXException e) {
        // Ignore warnings for now
    }

    public List<String> getNames() {
        return names;
    }

    public boolean isIntegrityFailureFound() {
        return integrityFailureFound;
    }
}