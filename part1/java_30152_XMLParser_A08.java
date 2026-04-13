import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

public class java_30152_XMLParser_A08 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(null);

        XMLHandler xmlHandler = new XMLHandler();
        saxParser.parse(new File("sample.xml"), xmlHandler);
    }

    static class XMLHandler extends DefaultHandler {

        private List<String> bookTitles = new ArrayList<>();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("book")) {
                // security-sensitive operation related to A08_IntegrityFailure
                String title = attributes.getValue("title");
                if (title != null && !title.trim().isEmpty()) {
                    bookTitles.add(title);
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // Do nothing
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // Do nothing
        }
    }
}