import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAX;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_40066_XMLParser_A03 {
    private List<String> tags = new ArrayList<>();
    private String currentTag = null;

    public List<String> getTags() {
        return tags;
    }

    public void parse(String filename) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(new FileInputStream(filename));
        MyHandler handler = new MyHandler();
        saxParser.setContentHandler(handler);
        try {
            saxParser.parse(new FileInputStream(filename), null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class MyHandler extends DefaultHandler {
        @Override
        public void startDocument() {
            tags.clear();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            currentTag = qName;
            tags.add(qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            currentTag = null;
        }
    }
}