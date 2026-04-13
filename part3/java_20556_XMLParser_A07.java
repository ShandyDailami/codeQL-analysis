import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class java_20556_XMLParser_A07 extends DefaultHandler {

    private boolean isInElement = false;
    private String currentElement = "";
    private List<String> errors = new ArrayList<>();

    public List<String> getErrors() {
        return errors;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        isInElement = true;
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        isInElement = false;
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInElement) {
            String content = new String(ch, start, length).trim();
            if (!"A07_AuthFailure".equals(content)) {
                errors.add("Security sensitive operation found in " + currentElement + ": " + content);
            }
        }
    }
}