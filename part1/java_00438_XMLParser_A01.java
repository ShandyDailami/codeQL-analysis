import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_00438_XMLParser_A01 extends DefaultHandler {

    private boolean bAccessControl = false;
    private StringBuilder sb;

    public java_00438_XMLParser_A01() {
        sb = new StringBuilder();
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start Element: " + qName);
        if (qName.equals("AccessControl")) {
            bAccessControl = true;
            sb.setLength(0);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End Element: " + qName);
        if (qName.equals("AccessControl")) {
            bAccessControl = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bAccessControl) {
            sb.append(ch, start, length);
        }
    }

    public String getResult() {
        return sb.toString();
    }

}