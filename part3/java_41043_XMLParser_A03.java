import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_41043_XMLParser_A03 extends DefaultHandler {

    private boolean isName;
    private boolean isAge;
    private boolean isAddress;
    private String currentElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("person")) {
            isName = true;
            isAge = true;
            isAddress = true;
        } else if (qName.equals("name")) {
            isName = true;
        } else if (qName.equals("age")) {
            isAge = true;
        } else if (qName.equals("address")) {
            isAddress = true;
        } else {
            isName = false;
            isAge = false;
            isAddress = false;
            currentElement = qName;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("person")) {
            isName = false;
            isAge = false;
            isAddress = false;
        } else if (qName.equals("name")) {
            isName = false;
        } else if (qName.equals("age")) {
            isAge = false;
        } else if (qName.equals("address")) {
            isAddress = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isName) {
            String name = new String(ch, start, length);
            // Process name
        } else if (isAge) {
            String age = new String(ch, start, length);
            // Process age
        } else if (isAddress) {
            String address = new String(ch, start, length);
            // Process address
        }
    }
}