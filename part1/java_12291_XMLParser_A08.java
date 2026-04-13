import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_12291_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            SAXParserFactory saxFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxFactory.newSAXParser(true);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("src/test.xml"), myHandler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean isTitleElement = false;
    private boolean isContentElement = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("title")) {
            isTitleElement = true;
        } else if (qName.equalsIgnoreCase("content")) {
            isContentElement = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (isTitleElement) {
            System.out.println("Title: " + qName);
            isTitleElement = false;
        } else if (isContentElement) {
            System.out.println("Content: " + qName);
            isContentElement = false;
        }
    }
}