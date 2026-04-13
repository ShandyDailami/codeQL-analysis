import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_21402_XMLParser_A03 extends DefaultHandler {
    private boolean isTitleElement = false;
    private boolean isLinkElement = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("title")) {
            isTitleElement = true;
        } else if (qName.equalsIgnoreCase("link")) {
            isLinkElement = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("title")) {
            isTitleElement = false;
        } else if (qName.equalsIgnoreCase("link")) {
            isLinkElement = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isTitleElement) {
            System.out.println("Title: " + new String(ch, start, length));
        } else if (isLinkElement) {
            System.out.println("Link: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) throws IOException, SAXException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(new File("input.xml"), new MyXMLParser());
    }
}