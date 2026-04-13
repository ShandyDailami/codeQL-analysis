import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

public class java_28356_XMLParser_A07 extends DefaultHandler {
    
    private boolean isInElement = false;
    private String currentElement = null;
    private String currentText = null;
    
    private List<String> authFailures;
    
    public java_28356_XMLParser_A07(List<String> authFailures) {
        this.authFailures = authFailures;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        isInElement = true;
        currentElement = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInElement) {
            currentText = new String(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        isInElement = false;
        
        if ("AuthFailure".equals(qName)) {
            if ("A07_AuthFailure".equals(currentElement) && currentText != null && !currentText.isEmpty()) {
                authFailures.add(currentText);
            }
        }
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        super.startPrefixMapping(prefix, uri);
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
        super.endPrefixMapping(prefix);
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        System.err.println("Error: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        System.err.println("Fatal error: " + e.getMessage());
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        System.err.println("Warning: " + e.getMessage());
    }
}