import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_21497_XMLParser_A07 extends DefaultHandler {

    private List<String> authFailureList;
    private String lastTag;

    public java_21497_XMLParser_A07() {
        authFailureList = new ArrayList<>();
    }

    public List<String> getAuthFailureList() {
        return authFailureList;
    }

    @Override
    public void startDocument() throws SAXException {
        authFailureList.clear();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastTag = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("AuthFailure".equals(qName)) {
            authFailureList.add("A07_AuthFailure");
        }
        lastTag = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if ("AuthFailure".equals(lastTag)) {
            authFailureList.add(new String(ch, start, length));
        }
    }

    @Override
    public void warning(SAXException e) throws SAXException {
        System.out.println("Warning: " + e.getMessage());
    }

    @Override
    public void error(SAXException e) throws SAXException {
        System.out.println("Error: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXException e) throws SAXException {
        System.out.println("Fatal Error: " + e.getMessage());
    }
}