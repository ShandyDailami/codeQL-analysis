import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_13969_XMLParser_A01 extends DefaultHandler {

    private StringBuilder data = new StringBuilder();
    private boolean bAuthorName = false;
    private boolean bBookTitle = false;
    private boolean bBookPrice = false;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("book")) {
            System.out.println("Start element book");
            bAuthorName = true;
            bBookTitle = true;
            bBookPrice = true;
        } else if (qName.equalsIgnoreCase("author")) {
            System.out.println("Start element author");
        } else if (qName.equalsIgnoreCase("title")) {
            System.out.println("Start element title");
        } else if (qName.equalsIgnoreCase("price")) {
            System.out.println("Start element price");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("book")) {
            System.out.println("End element book");
            bAuthorName = false;
            bBookTitle = false;
            bBookPrice = false;
        } else if (qName.equalsIgnoreCase("author")) {
            System.out.println("End element author");
        } else if (qName.equalsIgnoreCase("title")) {
            System.out.println("End element title");
        } else if (qName.equalsIgnoreCase("price")) {
            System.out.println("End element price");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bAuthorName) {
            System.out.println("Author name: " + new String(ch, start, length));
            bAuthorName = false;
        } else if (bBookTitle) {
            System.out.println("Book title: " + new String(ch, start, length));
            bBookTitle = false;
        } else if (bBookPrice) {
            System.out.println("Book price: " + new String(ch, start, length));
            bBookPrice = false;
        }
    }
}