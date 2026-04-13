import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class java_04345_XMLParser_A07 extends DefaultHandler {

    private List<String> names;
    private String currentLocalName;
    private String currentValue;

    public java_04345_XMLParser_A07() {
        names = new ArrayList<>();
    }

    public List<String> getNames() {
        return names;
    }

    @Override
    public void startDocument() throws SAXException {
        names = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentLocalName = localName;
        currentValue = "";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (currentLocalName.equals(localName)) {
            names.add(currentValue);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        currentValue = new String(ch, start, length);
    }
}