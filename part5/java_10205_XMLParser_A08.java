import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_10205_XMLParser_A08 {

    public static void main(String[] args) {
        String fileName = "example.xml";
        File file = new File(fileName);

        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(new XMLReaderFactory().createXMLReader());

            MyHandler myHandler = new MyHandler();
            saxParser.parse(file, myHandler);
        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] chars, int start, int length) {
            System.out.println("Characters: " + new String(chars, start, length));
        }
    }
}