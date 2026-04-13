import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_20320_XMLParser_A07 extends DefaultHandler {

    private boolean bAuthFailure = false;
    private List<String> authFailures = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("AuthFailure")) {
            bAuthFailure = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("AuthFailure")) {
            bAuthFailure = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bAuthFailure) {
            String failure = new String(ch, start, length);
            authFailures.add(failure);
        }
    }

    public List<String> getAuthFailures() {
        return authFailures;
    }
}