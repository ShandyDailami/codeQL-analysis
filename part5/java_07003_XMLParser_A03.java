import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;
import org.xml.sax.parser.XMLEventHandler;
import org.xml.sax.xmlreader.XMLReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class java_07003_XMLParser_A03 {

    private List<String> tags = new ArrayList<>();
    private StringBuilder text = new StringBuilder();

    private class MyHandler extends DefaultHandler {

        private boolean bTag = false;
        private String currentElement = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if(qName.equalsIgnoreCase("tag")) {
                bTag = true;
                currentElement = qName;
            } else {
                text.setLength(0);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if(bTag) {
                text.append(new String(ch, start, length));
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if(qName.equalsIgnoreCase("tag")) {
                bTag = false;
                tags.add(currentElement + ": " + text.toString());
            }
        }
    }

    public void parse(String fileName) {
        try {
            FileInputStream fis = new FileInputStream(new File(fileName));
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(new MyHandler());
            saxParser.parse(fis, new DummyHandler());

            for(String tag : tags) {
                System.out.println(tag);
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        XmlParserExample xmlParserExample = new XmlParserExample();
        xmlParserExample.parse("test.xml");
    }

    private static class DummyHandler extends DefaultHandler {
        @Override
        public void startDocument() throws SAXException {
        }

        @Override
        public void endDocument() throws SAXException {
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
        }
    }
}