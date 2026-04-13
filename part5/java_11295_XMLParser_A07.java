import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_11295_XMLParser_A07 extends DefaultHandler {
    private boolean isUser;
    private boolean isRole;
    private String currentElement;

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
        this.currentElement = qName;
        if (qName.equals("user")) {
            this.isUser = true;
        } else if (qName.equals("role")) {
            this.isRole = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        this.currentElement = null;
        if (qName.equals("user")) {
            this.isUser = false;
        } else if (qName.equals("role")) {
            this.isRole = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (this.isUser) {
            System.out.println("User: " + new String(ch, start, length));
        } else if (this.isRole) {
            System.out.println("Role: " + new String(ch, start, length));
        }
    }
}