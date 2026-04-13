import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLEventReader;
import org.xml.sax.parser.XMLEventWriter;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class java_03915_XMLParser_A01 extends DefaultHandler {

    private String thisElement = "";
    private String thisAttribute = "";
    private String thisNamespace = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        thisElement = qName;
        thisNamespace = uri;
        thisAttribute = attributes.getValue("");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (thisElement.equals("book")) {
            System.out.println("Book Title: " + new String(ch, start, length));
        } else if (thisElement.equals("author")) {
            System.out.println("Author: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) throws IOException, SAXException {
        File inputFile = new File("books.xml");
        XMLEventReader eventReader = SAXParserFactory.newInstance().newSAXReader();

        MyXMLParser handler = new MyXMLParser();
        eventReader.setContentHandler(handler);

        eventReader.parse(new FileReader(inputFile));
    }
}