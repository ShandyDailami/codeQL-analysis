import java.io.File;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLEventReader;
import org.xml.sax.parser.XMLEventWriter;

public class java_17446_XMLParser_A08 extends DefaultHandler {

    private boolean bookFound = false;
    private String thisElementContent = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("book")) {
            bookFound = true;
            thisElementContent = "";
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bookFound) {
            thisElementContent += new String(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("book")) {
            parseBook(thisElementContent);
            bookFound = false;
        } else if (bookFound && qName.equals("id")) {
            // here you should verify the integrity of the id, and maybe do something
            // example: if(Integer.parseInt(thisElementContent) > 10000) {...}
        } else if (bookFound && qName.equals("name")) {
            // here you should verify the integrity of the name, and maybe do something
            // example: if(thisElementContent.length() > 50) {...}
        } else if (bookFound && qName.equals("price")) {
            // here you should verify the integrity of the price, and maybe do something
            // example: if(Double.parseDouble(thisElementContent) > 100) {...}
        }
    }

    private void parseBook(String bookInfo) {
        String[] bookParts = bookInfo.split("\\s+");
        for (String part : bookParts) {
            if (part.equals("id")) {
                // here you should verify the integrity of the id
            } else if (part.equals("name")) {
                // here you should verify the integrity of the name
            } else if (part.equals("price")) {
                // here you should verify the integrity of the price
            }
        }
    }

    public static void main(String[] args) throws Exception {
        XMLParserExample handler = new XMLParserExample();
        XMLEventReader reader = org.xml.sax.parser.XMLReaderFactory.createXMLReader();
        reader.setContentHandler(handler);
        reader.parse("sample.xml"); // replace with your file path
    }
}