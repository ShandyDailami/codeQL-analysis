import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class java_24625_XMLParser_A07 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null, new MyHandler());
            saxParser.parse(new File("path/to/your/xml/file"), null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        private List<String> links = new ArrayList<>();
        private List<String> titles = new ArrayList<>();
        private String thisElement;
        private String thisValue;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            this.thisElement = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ("title".equals(this.thisElement)) {
                titles.add(this.thisValue);
            } else if ("link".equals(this.thisElement)) {
                links.add(this.thisValue);
            }
            this.thisElement = null;
            this.thisValue = null;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            this.thisValue = new String(ch, start, length);
        }
    }
}