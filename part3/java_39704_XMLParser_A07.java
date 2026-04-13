import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_39704_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("books.xml");
            XMLReader reader = XMLReaderFactory.createXMLReader();
            BookHandler handler = new BookHandler();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class BookHandler implements org.xml.sax.helpers.DefaultHandler {
    boolean bAuthor;
    boolean bTitle;
    boolean bPrice;
    String currElement;

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
            System.out.println("Book Name: ");
            bAuthor = true;
            bTitle = true;
            bPrice = true;
        } else if (bAuthor) {
            System.out.println("Author: " + localName);
            bAuthor = false;
        } else if (bTitle) {
            System.out.println("Title: " + localName);
            bTitle = false;
        } else if (bPrice) {
            System.out.println("Price: " + localName);
            bPrice = false;
        }
        currElement = localName;
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("book")) {
            System.out.println();
            bAuthor = false;
            bTitle = false;
            bPrice = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (bAuthor || bTitle || bPrice) {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}