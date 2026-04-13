import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLEventHandler;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLEventHandler;
import org.xml.sax.SAXParseException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class java_05240_XMLParser_A03 {
    private List<String> names;
    private DefaultHandler defaultHandler;
    private XMLParser parser;

    public java_05240_XMLParser_A03(File file) throws SAXException, IOException {
        names = new java.util.ArrayList<String>();
        defaultHandler = new DefaultHandler();
        parser = XMLParser.newInstance(file, defaultHandler, true);
    }

    public void parse() throws SAXException, IOException {
        parser.parse();
    }

    private class MyHandler extends DefaultHandler {
        private int depth;

        @Override
        public void startDocument() {
            depth = 0;
        }

        @Override
        public void endDocument() {
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            names.add(qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            depth--;
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (depth > 0) {
                depth++;
            }
        }
    }

    public List<String> getNames() {
        return names;
    }
}