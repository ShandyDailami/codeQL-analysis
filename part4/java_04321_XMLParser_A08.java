import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_04321_XMLParser_A08 extends DefaultHandler {
    private boolean isTitle = false;
    private boolean isLink = false;
    private String currentTag = "";
    private StringBuilder content = new StringBuilder();

    @Override
    public void startDocument() {
        System.out.println("Starting document");
    }

    @Override
    public void endDocument() {
        System.out.println("Ending document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println("Starting element: " + qName);
        currentTag = qName;
        if (qName.equals("item")) {
            isTitle = true;
        } else {
            isLink = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.println("Ending element: " + qName);
        if (qName.equals("item")) {
            isTitle = false;
        } else if (qName.equals("link")) {
            isLink = true;
        }
        currentTag = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        System.out.println("Characters: " + new String(ch, start, length));
        content.append(new String(ch, start, length));
    }

    @Override
    public void error(SAXException e) {
        System.out.println("Error: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXException e) {
        System.out.println("Fatal error: " + e.getMessage());
    }

    @Override
    public void warning(SAXException e) {
        System.out.println("Warning: " + e.getMessage());
    }
}