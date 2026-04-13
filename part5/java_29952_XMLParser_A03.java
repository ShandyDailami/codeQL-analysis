import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_29952_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("sample.xml"), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private StringBuilder currentElementContent;

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
        currentElementContent = new StringBuilder();
        System.out.println("Start of element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (currentElementContent != null) {
            System.out.println("End of element: " + qName);
            System.out.println("Content of element: " + currentElementContent.toString());
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        currentElementContent.append(new String(ch, start, length));
    }
}