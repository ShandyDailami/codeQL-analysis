import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_30431_XMLParser_A07 {
    private static final String XML_FILE = "src/main/resources/sample.xml";

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(XML_FILE, myHandler);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        @Override
        public void startDocument() {
            System.out.println("Start of the document");
        }

        @Override
        public void endDocument() {
            System.out.println("End of the document");
        }

        @Override
        public void startElement(String uri, String localName, String qName) {
            System.out.println("Start of element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End of element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            String str = new String(ch, start, length).trim();
            if (str.isEmpty()) {
                return;
            }
            System.out.println("Character data: " + str);
        }

        @Override
        public void fatalError(String error) {
            System.out.println("Fatal Error: " + error);
        }

        @Override
        public void warning(String msg) {
            System.out.println("Warning: " + msg);
        }
    }
}