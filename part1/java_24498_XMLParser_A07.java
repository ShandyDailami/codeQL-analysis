import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_24498_XMLParser_A07 {

    public static void main(String[] args) {
        String fileName = "books.xml";

        // Create a SAX parser factory.
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();

        try {
            // Create a SAX parser from the SAX parser factory.
            SAXParser saxParser = saxFactory.newSAXParser();

            // Create a handler that will be notified when an element is parsed.
            ContentHandler handler = new ContentHandler();

            // Create a XMLReader from the SAX parser.
            XMLReader xmlReader = XMLReaderFactory.createXMLReader(handler);

            // Parse the XML file.
            xmlReader.parse(new File(fileName));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public static class ContentHandler extends DefaultHandler {

        private boolean bookTitle = false;
        private boolean bookAuthor = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {

            if (qName.equals("book")) {
                bookTitle = true;
                bookAuthor = true;
            }

            if (qName.equals("title")) {
                bookTitle = true;
            }

            if (qName.equals("author")) {
                bookAuthor = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {

            if (qName.equals("book")) {
                bookTitle = false;
                bookAuthor = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {

            if (bookTitle) {
                System.out.println("Title: " + new String(ch, start, length));
                bookTitle = false;
            }

            if (bookAuthor) {
                System.out.println("Author: " + new String(ch, start, length));
                bookAuthor = false;
            }
        }
    }
}