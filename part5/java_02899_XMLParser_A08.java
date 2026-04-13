import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_02899_XMLParser_A08 extends DefaultHandler {

    private boolean isPerson = false;
    private boolean isName = false;
    private boolean isAge = false;
    private String currentElement;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Parsing started");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Parsing ended");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;

        if (qName.equalsIgnoreCase("person")) {
            isPerson = true;
        } else {
            //Process other elements here
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = "";

        if (qName.equalsIgnoreCase("person")) {
            isPerson = false;
        } else if (qName.equalsIgnoreCase("name")) {
            isName = false;
        } else if (qName.equalsIgnoreCase("age")) {
            isAge = false;
        } else {
            //Process other elements here
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isPerson) {
            System.out.println("Person: " + new String(ch, start, length));
        } else if (isName) {
            System.out.println("Name: " + new String(ch, start, length));
        } else if (isAge) {
            System.out.println("Age: " + new String(ch, start, length));
        }
    }
}