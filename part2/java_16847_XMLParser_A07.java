import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLErrorHandler;

import java.io.File;
import java.io.IOException;

public class java_16847_XMLParser_A07 {

    public static void main(String[] args) {
        XMLParserHandler handler = new XMLParserHandler();

        try {
            XMLParser parser = new SAXParser(handler, new DTDHandler());
            parser.parse(new File("sample.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class XMLParserHandler extends DefaultHandler {

    private String currentElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement != null) {
            System.out.println(currentElement + ": " + new String(ch, start, length));
        }
    }
}