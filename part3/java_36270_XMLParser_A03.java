import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_36270_XMLParser_A03 extends DefaultHandler {

    private String thisElement;
    private boolean isName;
    private boolean isId;
    private boolean isTitle;
    private boolean isContent;

    public java_36270_XMLParser_A03() {
        thisElement = "";
        isName = false;
        isId = false;
        isTitle = false;
        isContent = false;
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
        thisElement = qName;

        if (qName.equals("name")) {
            isName = true;
        } else if (qName.equals("id")) {
            isId = true;
        } else if (qName.equals("title")) {
            isTitle = true;
        } else if (qName.equals("content")) {
            isContent = true;
        } else {
            isName = isId = isTitle = isContent = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End Element: " + qName);
        thisElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isName || isId || isTitle || isContent) {
            String value = new String(ch, start, length);
            System.out.println("Element: " + thisElement + ", Value: " + value);
        }
    }

    @Override
    public void warning(SAXException e) {
        System.out.println("Warning: " + e.getMessage());
    }

    @Override
    public void error(SAXException e) {
        System.out.println("Error: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXException e) {
        System.out.println("Fatal Error: " + e.getMessage());
    }
}