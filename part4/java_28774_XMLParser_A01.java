import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_28774_XMLParser_A01 {
    public static void main(String[] args) {
        File inputFile = new File("sample.xml");
        parse(inputFile);
    }

    public static void parse(File inputFile) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyHandler());
            reader.parse(new FileInputStream(inputFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private boolean isName = false;
        private boolean isAge = false;
        private String name;
        private int age;

        @Override
        public void startDocument() throws SAXParseException {
            System.out.println("Start document");
        }

        @Override
        public void endDocument() throws SAXParseException {
            System.out.println("End document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("Person")) {
                isName = true;
                isAge = true;
            } else if (qName.equals("Name")) {
                isName = true;
            } else if (qName.equals("Age")) {
                isAge = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("Person")) {
                System.out.println("Name: " + name + ", Age: " + age);
                isName = false;
                isAge = false;
            } else if (qName.equals("Name")) {
                isName = false;
            } else if (qName.equals("Age")) {
                isAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isName) {
                name = new String(ch, start, length);
            } else if (isAge) {
                age = Integer.parseInt(new String(ch, start, length));
            }
        }
    }
}