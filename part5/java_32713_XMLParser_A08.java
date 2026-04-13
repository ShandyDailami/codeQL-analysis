import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_32713_XMLParser_A08 {

    private static class MyHandler extends DefaultHandler {

        private int depth = 0;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            depth++;
            printElement(uri, localName, qName, attributes);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            depth--;
        }

        private void printElement(String uri, String localName, String qName, Attributes attributes) {
            if (depth == 1) {
                System.out.println("Start of: " + qName);
            } else {
                printIndentation(depth);
                System.out.println("Element: " + qName);
            }
        }

        private void printIndentation(int depth) {
            for (int i = 0; i < depth; i++) {
                System.out.print("    ");
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (depth == 1) {
                System.out.print(new String(ch, start, length));
            }
        }
    }

    public static void main(String[] args) {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {
            SAXParser sp = spf.newSAXParser(null);
            sp.parse(new File("sample.xml"), new MyHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}