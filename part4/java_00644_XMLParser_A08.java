import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_00644_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFile = "example.xml"; // replace with your xml file

        try {
            File inputFile = new File(xmlFile);

            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();

            MyHandler myHandler = new MyHandler();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(myHandler);

            saxParser.parse(inputFile, xmlReader);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements org.xml.sax.helpers.DefaultHandler {

    private boolean bName = false;
    private boolean bAuthor = false;
    private boolean bGenre = false;

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
            bName = true;
            bAuthor = false;
            bGenre = false;
        } else if (qName.equalsIgnoreCase("name")) {
            bName = true;
            bAuthor = false;
            bGenre = false;
        } else if (qName.equalsIgnoreCase("author")) {
            bAuthor = true;
            bName = false;
            bGenre = false;
        } else if (qName.equalsIgnoreCase("genre")) {
            bGenre = true;
            bName = false;
            bAuthor = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("book")) {
            System.out.println("\nEnd of book");
        } else if (qName.equalsIgnoreCase("name")) {
            System.out.println("Book name: ");
        } else if (qName.equalsIgnoreCase("author")) {
            System.out.println("Author: ");
        } else if (qName.equalsIgnoreCase("genre")) {
            System.out.println("Genre: ");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (bName) {
            System.out.print("Name: ");
            System.out.println(new String(ch, start, length));
            bName = false;
        } else if (bAuthor) {
            System.out.print("Author: ");
            System.out.println(new String(ch, start, length));
            bAuthor = false;
        } else if (bGenre) {
            System.out.print("Genre: ");
            System.out.println(new String(ch, start, length));
            bGenre = false;
        }
    }
}