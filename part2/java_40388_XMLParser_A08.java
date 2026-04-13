import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_40388_XMLParser_A08 extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;

    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            bName = true;
            bAge = true;
        } else if (bName && qName.equalsIgnoreCase("name")) {
            System.out.println("Name: ");
        } else if (bName && qName.equalsIgnoreCase("age")) {
            System.out.println("Age: ");
        }
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            bName = false;
            bAge = false;
        }
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (bName) {
            System.out.println(new String(ch, start, length));
        } else if (bAge) {
            System.out.println("Age: " + new String(ch, start, length));
        }
    }
}