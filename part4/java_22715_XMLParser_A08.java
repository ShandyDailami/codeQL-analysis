import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_22715_XMLParser_A08 extends DefaultHandler {

    private String lastElement;
    private boolean isTitle;
    private boolean isLink;

    public void startDocument() throws SAXException {
        System.out.println("Start of Document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of Document");
    }

    public void startElement(String uri, String localName, String qName)
            throws SAXException {
        lastElement = qName;
        if (qName.equals("bookstore")) {
            System.out.println("<bookstore> found");
        } else if (qName.equals("book")) {
            System.out.println("<book> found");
            isTitle = false;
            isLink = false;
        } else if (qName.equals("title")) {
            System.out.println("<title> found");
            isTitle = true;
        } else if (qName.equals("link")) {
            System.out.println("<link> found");
            isLink = true;
        }
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equals(lastElement)) {
            System.out.println("</" + qName + "> found");
        }
        if (qName.equals("book")) {
            System.out.println("</book> found");
        }
        if (qName.equals("title")) {
            System.out.println("</title> found");
        }
        if (qName.equals("link")) {
            System.out.println("</link> found");
        }
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (isTitle) {
            System.out.println("Title: " + new String(ch, start, length));
        } else if (isLink) {
            System.out.println("Link: " + new String(ch, start, length));
        }
    }

    public void fatalError(SAXException e) throws SAXException {
        System.out.println("Fatal Error: " + e.getMessage());
    }

    public void warning(SAXException e) throws SAXException {
        System.out.println("Warning: " + e.getMessage());
    }
}