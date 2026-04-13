import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_20288_XMLParser_A08 extends DefaultHandler {
    public boolean integrityFailure = false;
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (localName.equalsIgnoreCase("integrityFailure")) {
            integrityFailure = true;
        }
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (localName.equalsIgnoreCase("integrityFailure")) {
            integrityFailure = false;
        }
    }
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (integrityFailure) {
            // Handle integrityFailure here
            System.out.println("IntegrityFailure Detected: " + new String(ch, start, length));
        }
    }
}