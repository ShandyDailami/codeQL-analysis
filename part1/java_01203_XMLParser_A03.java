import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_01203_XMLParser_A03 extends DefaultHandler {

    private boolean bName = false;
    private boolean bAge = false;
    private String currentElement = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        currentElement = qName;
        if (qName.equalsIgnoreCase("person")) {
            bName = true;
            bAge = true;
        } else {
            if (bName) {
                if (qName.equalsIgnoreCase("name")) {
                    bName = false;
                }
            }
            if (bAge) {
                if (qName.equalsIgnoreCase("age")) {
                    bAge = false;
                }
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (currentElement != null) {
            if (currentElement.equalsIgnoreCase("person")) {
                System.out.println("Person Info: ");
            } else if (currentElement.equalsIgnoreCase("name")) {
                System.out.println("Name: ");
            } else if (currentElement.equalsIgnoreCase("age")) {
                System.out.println("Age: ");
            }
        }
        currentElement = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement != null) {
            String value = new String(ch, start, length);
            if (currentElement.equalsIgnoreCase("name")) {
                System.out.println("Name: " + value);
            } else if (currentElement.equalsIgnoreCase("age")) {
                System.out.println("Age: " + value);
            }
        }
    }
}