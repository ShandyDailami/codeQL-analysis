import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.List;

public class java_25418_XMLParser_A07 extends DefaultHandler {
    private List<String> tags;
    private String currentElement;
    private boolean inUsername;
    private boolean inPassword;

    public java_25418_XMLParser_A07(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;

        if (tags.contains(currentElement)) {
            if (currentElement.equals("username")) {
                inUsername = true;
            } else if (currentElement.equals("password")) {
                inPassword = true;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (currentElement.equals(qName)) {
            if (tags.contains(currentElement)) {
                if (currentElement.equals("username")) {
                    inUsername = false;
                } else if (currentElement.equals("password")) {
                    inPassword = false;
                }
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (inUsername) {
            // Handle username authentication here. 
            // If authentication fails, throw an exception or handle it.
        }

        if (inPassword) {
            // Handle password authentication here.
            // Again, if authentication fails, throw an exception or handle it.
        }
    }
}