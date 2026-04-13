import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class java_36331_XMLParser_A07 extends DefaultHandler {
    private List<String> authFailures;
    private StringBuilder currentElement;

    public java_36331_XMLParser_A07() {
        this.authFailures = new ArrayList<>();
        this.currentElement = new StringBuilder();
    }

    public List<String> getAuthFailures() {
        return authFailures;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentElement.setLength(0);
        currentElement.append(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if ("AuthFailure".equals(localName)) {
            authFailures.add(currentElement.toString());
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        currentElement.append(new String(ch, start, length));
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) {
        // ignore prefix mapping
    }

    @Override
    public void endPrefixMapping(String prefix) {
        // ignore prefix mapping
    }
}