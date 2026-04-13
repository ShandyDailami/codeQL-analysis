import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_32920_XMLParser_A08 extends DefaultHandler {

    private boolean bookFlag = false;
    private String bookTitle = null;
    private String bookAuthor = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("book")) {
            bookFlag = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("book")) {
            System.out.println("Book Title: " + bookTitle);
            System.out.println("Book Author: " + bookAuthor);
            bookFlag = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bookFlag) {
            bookTitle = new String(ch, start, length);
        } else {
            bookAuthor = new String(ch, start, length);
        }
    }

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser();
            XMLReader reader = saxParser.getXMLReader();

            MyHandler myHandler = new MyHandler();
            reader.setContentHandler(myHandler);

            reader.parse(new File("books.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}