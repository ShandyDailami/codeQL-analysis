import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_13811_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();
            MyHandler handler = new MyHandler();
            parser.parse(new File("input.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private int depth = 0;

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
            printIndentation(depth);
            System.out.println("Start of tag: " + qName);
            depth++;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            depth--;
            printIndentation(depth);
            System.out.println("End of tag: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String content = new String(ch, start, length).trim();
            if (content.length() > 0) {
                printIndentation(depth);
                System.out.println("Content: " + content);
            }
        }

        private void printIndentation(int depth) {
            for (int i = 0; i < depth; i++) {
                System.out.print("  ");
            }
        }
    }
}