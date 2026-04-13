import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_14095_XMLParser_A01 extends DefaultHandler {

    private boolean bIsTitleElement = false;
    private boolean bIsAuthorElement = false;

    public java_14095_XMLParser_A01() {
        super();
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
    public void startElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("book")) {
            System.out.println("Start of book element");
            bIsTitleElement = false;
            bIsAuthorElement = false;
        } else if (qName.equalsIgnoreCase("title")) {
            bIsTitleElement = true;
        } else if (qName.equalsIgnoreCase("author")) {
            bIsAuthorElement = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("book")) {
            System.out.println("End of book element");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (bIsTitleElement) {
            System.out.println("Title: " + new String(ch, start, length));
        } else if (bIsAuthorElement) {
            System.out.println("Author: " + new String(ch, start, length));
        }
    }
}