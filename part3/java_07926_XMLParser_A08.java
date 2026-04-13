import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_07926_XMLParser_A08 extends DefaultHandler {

    private boolean bName = false;
    private boolean bAge = false;
    private String currentValue = null;

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
        if ("person".equals(qName)) {
            bName = true;
            bAge = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("person".equals(qName)) {
            bName = false;
            bAge = false;
       
            if (currentValue != null) {
                System.out.println("Name: " + currentValue + ", Age: " + currentValue);
                currentValue = null;
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            currentValue = new String(ch, start, length);
        }

        if (bAge) {
            currentValue = new String(ch, start, length);
        }
    }
}