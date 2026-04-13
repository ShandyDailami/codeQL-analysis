import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

public class java_34365_XMLParser_A07 extends DefaultHandler {

    private boolean isName = false;
    private boolean isAge = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            isName = true;
            isAge = true;
        } else if (isName) {
            if (qName.equalsIgnoreCase("name")) {
                isName = false;
            }
        } else if (isAge) {
            if (qName.equalsIgnoreCase("age")) {
                isAge = false;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            System.out.println("End of person");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isName) {
            String data = new String(ch, start, length);
            System.out.println("Name: " + data);
        } else if (isAge) {
            String data = new String(ch, start, length);
            System.out.println("Age: " + data);
        }
    }
}