import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_21096_XMLParser_A01 extends DefaultHandler {

    private boolean bName;
    private boolean bAge;
    private String qName;
    
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start Element: " + qName);
        this.qName = qName;

        if (qName.equalsIgnoreCase("person")) {
            bName = true;
            bAge = false;
        } else if (qName.equalsIgnoreCase("name")) {
            bName = true;
            bAge = false;
        } else if (qName.equalsIgnoreCase("age")) {
            bAge = true;
            bName = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End Element: " + qName);
        if (this.qName.equalsIgnoreCase(qName)) {
            if (bName) {
                System.out.println("Name: " + localName);
            } else if (bAge) {
                System.out.println("Age: " + localName);
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            System.out.println("Character Data: " + new String(ch, start, length));
        } else if (bAge) {
            System.out.println("Age: " + new String(ch, start, length));
        }
    }
}