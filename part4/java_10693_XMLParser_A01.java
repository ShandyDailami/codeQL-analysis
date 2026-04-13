import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_10693_XMLParser_A01 extends DefaultHandler {
    private String thisElement;
    private boolean bName;
    private boolean bAge;

    public java_10693_XMLParser_A01() {
        bName = false;
        bAge = false;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        thisElement = qName;
        if (qName.equals("person")) {
            bName = true;
            bAge = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        thisElement = "";
        if (qName.equals("name")) {
            bName = false;
        } else if (qName.equals("age")) {
            bAge = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            System.out.println("Name: " + new String(ch, start, length));
        } else if (bAge) {
            System.out.println("Age: " + new String(ch, start, length));
        }
    }
}