import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_23517_XMLParser_A07 extends DefaultHandler {

    private boolean isAuthFailure = false;
    private boolean isAuthSuccess = false;
    private List<String> authFailures = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("AuthFailure")) {
            isAuthFailure = true;
        } else if (qName.equals("AuthSuccess")) {
            isAuthSuccess = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("AuthFailure")) {
            isAuthFailure = false;
        } else if (qName.equals("AuthSuccess")) {
            isAuthSuccess = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isAuthFailure) {
            authFailures.add(new String(ch, start, length));
        }
    }

    @Override
    public void endDocument() throws SAXException {
        if (isAuthSuccess) {
            System.out.println("Security check passed. No auth failures found.");
        } else {
            System.out.println("Security check failed. The following auth failures were found: " + authFailures);
        }
    }
}