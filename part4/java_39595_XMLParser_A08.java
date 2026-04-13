import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_39595_XMLParser_A08 extends DefaultHandler {
    private boolean bName = false;
    private boolean bAuthor = false;
    private boolean bPrice = false;
    private String currElem = "";

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName) throws SAXException {
        currElem = qName;
        if (qName.equals("book")) {
            System.out.println("Book Start");
        } else {
            if (qName.equals("name")) {
                bName = true;
            } else if (qName.equals("author")) {
                bAuthor = true;
            } else if (qName.equals("price")) {
                bPrice = true;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("book")) {
            System.out.println("Book End");
        } else {
            if (currElem.equals("name")) {
                bName = false;
            } else if (currElem.equals("author")) {
                bAuthor = false;
            } else if (currElem.equals("price")) {
                bPrice = false;
           
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            System.out.println("Name: " + new String(ch, start, length));
        } else if (bAuthor) {
            System.out.println("Author: " + new String(ch, start, length));
        } else if (bPrice) {
            System.out.println("Price: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        SAXParserExample handler = new SAXParserExample();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser(null, handler);
            saxParser.parse(new InputSource(new StringReader("<books><book><name>Book1</name><author>Author1</author><price>100</price></book><book><name>Book2</name><author>Author2</author><price>200</price></book></books>")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}