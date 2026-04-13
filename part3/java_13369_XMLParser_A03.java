import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_13369_XMLParser_A03 extends DefaultHandler {

    private boolean bTagFound = false;
    private String currentElement = "";
    private StringBuilder content = new StringBuilder();

    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        bTagFound = false;
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = "";
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        content.append(new String(ch, start, length));
    }

    public void warning(SAXException e) {
        System.out.println("SAX warning: " + e.getMessage());
    }

    public void error(SAXException e) {
        System.out.println("SAX error: " + e.getMessage());
    }

    public void fatalError(SAXException e) {
        System.out.println("Fatal SAX error: " + e.getMessage());
    }
}