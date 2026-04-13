import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_19483_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("data.xml"), myHandler);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean isTitleElement = false;
    private boolean isAuthorElement = false;
    private boolean isYearElement = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("title")) {
            isTitleElement = true;
        } else if (qName.equalsIgnoreCase("author")) {
            isAuthorElement = true;
        } else if (qName.equalsIgnoreCase("year")) {
            isYearElement = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("title")) {
            isTitleElement = false;
        } else if (qName.equalsIgnoreCase("author")) {
            isAuthorElement = false;
        } else if (qName.equalsIgnoreCase("year")) {
            isYearElement = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isTitleElement) {
            System.out.println("Title: " + new String(ch, start, length));
        } else if (isAuthorElement) {
            System.out.println("Author: " + new String(ch, start, length));
        } else if (isYearElement) {
            System.out.println("Year: " + new String(ch, start, length));
        }
    }
}