import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

public class java_30726_XMLParser_A03 extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;
    private String strName = null;
    private String strAge = null;

    @Override
    public void startDocument() throws SAXParseException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXParseException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            bName = true;
            bAge = true;
        } else if (bName) {
            bName = false;
            strName = localName;
        } else if (bAge) {
            bAge = false;
            strAge = localName;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            System.out.println("Name: " + strName + ", Age: " + strAge);
            bName = false;
            bAge = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            strName = new String(ch, start, length);
        } else if (bAge) {
            strAge = new String(ch, start, length);
        }
    }
}