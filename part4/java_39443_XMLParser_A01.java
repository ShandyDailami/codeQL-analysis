import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_39443_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(true);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("resources/test.xml"), myHandler);
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        boolean bStart = false;
        boolean bEnd = false;
        String temp = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            bStart = true;
            bEnd = false;
            temp = "";
        }

        @Override
        public java_39443_XMLParser_A01(String uri, String localName, String qName)
                throws SAXException {
            bEnd = true;
            bStart = false;
            System.out.println(qName + " : " + temp);
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            if (bStart) {
                temp = new String(ch, start, length);
            }
        }
    }
}