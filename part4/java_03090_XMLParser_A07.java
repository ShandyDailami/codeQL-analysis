import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_03090_XMLParser_A07 {
    public static void main(String[] args) {
        File xmlFile = new File("books.xml");
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new XMLHandler());
            parser.parse(xmlFile, new DefaultHandler());
        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }
}

class XMLHandler extends DefaultHandler {
    private boolean bookTitle = false;
    private String currentElement = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("book")) {
            bookTitle = true;
        } else if (bookTitle) {
            bookTitle = false;
            currentElement = qName;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bookTitle) {
            System.out.println("Book Title: " + new String(ch, start, length));
        }
    }
}