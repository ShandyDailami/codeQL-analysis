import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.Xerces2SAXParser;
import org.xml.sax.xmlreader.XMLRPCReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class java_14708_XMLParser_A01 {
    private DefaultHandler defaultHandler;
    private List<String> tags;

    public java_14708_XMLParser_A01() {
        this.defaultHandler = new DefaultHandler();
        this.tags = new ArrayList<>();
    }

    public void parse(String fileName) throws Exception {
        SAXParser parser = new Xerces2SAXParser();
        parser.setContentHandler(this.defaultHandler);
        InputStream inputStream = new FileInputStream(new File(fileName));
        parser.parse(inputStream);
    }

    private class DefaultHandler extends org.xml.sax.helpers.DefaultHandler {
        private List<String> currentTags;

        @Override
        public void startDocument() throws SAXException {
            currentTags = new ArrayList<>();
        }

        @Override
        public void endDocument() throws SAXException {
            // No action required
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentTags.add(qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            currentTags.remove(qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (currentTags.contains("Person")) {
                System.out.println("Name: " + new String(ch, start, length));
            }
        }
    }
}