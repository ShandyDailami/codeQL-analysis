import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_13792_XMLParser_A08 extends DefaultHandler {

    boolean bAuthor;
    boolean bTitle;
    boolean bYear;
    boolean bPrice;
    String strAuthor;
    String strTitle;
    String strYear;
    String strPrice;

    public java_13792_XMLParser_A08() {
        bAuthor = bTitle = bYear = bPrice = true;
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
            bAuthor = bTitle = bYear = bPrice = false;
        } else if (qName.equalsIgnoreCase("author")) {
            bAuthor = true;
        } else if (qName.equalsIgnoreCase("title")) {
            bTitle = true;
        } else if (qName.equalsIgnoreCase("year")) {
            bYear = true;
        } else if (qName.equalsIgnoreCase("price")) {
            bPrice = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("book")) {
            bAuthor = bTitle = bYear = bPrice = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (bAuthor) {
            strAuthor = new String(ch, start, length);
        } else if (bTitle) {
            strTitle = new String(ch, start, length);
        } else if (bYear) {
            strYear = new String(ch, start, length);
        } else if (bPrice) {
            strPrice = new String(ch, start, length);
        }
    }
}

public class Test {
    public static void main(String[] args) {
        try {
            SAXParserFactory saxpFactory = SAXParserFactory.newInstance();
            SAXParser saxp = saxpFactory.newSAXParser(false);

            MySAXHandler myHandler = new MySAXHandler();
            saxp.parse("books.xml", myHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}