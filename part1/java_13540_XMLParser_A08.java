import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_13540_XMLParser_A08 extends DefaultHandler {
    private boolean isTitleElement = false;
    private boolean isLinkElement = false;
    private String currentElement = null;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("link".equals(qName)) {
            isLinkElement = true;
        } else if ("title".equals(qName)) {
            isTitleElement = true;
        }

        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("link".equals(qName)) {
            isLinkElement = false;
        } else if ("title".equals(qName)) {
            isTitleElement = false;
        }

        currentElement = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isTitleElement || isLinkElement) {
            String content = new String(ch, start, length);
            System.out.println("Content is: " + content.trim());
        }
    }

    public static void main(String[] args) {
        MyXMLParser handler = new MyXMLParser();
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, handler);
            parser.parse(new File("example.xml"), handler);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}