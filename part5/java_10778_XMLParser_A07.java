import java.net.URL;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_10778_XMLParser_A07 extends DefaultHandler {

    public static void main(String[] args) {
        String urlStr = "http://example.com/books.xml";

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        MyXMLParser handler = new MyXMLParser();
        parser.parse(new URL(urlStr).openStream(), handler);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length);
        System.out.println("Content: " + content);
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        System.out.println("Start prefix mapping: " + prefix);
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
        System.out.println("End prefix mapping: " + prefix);
    }
}