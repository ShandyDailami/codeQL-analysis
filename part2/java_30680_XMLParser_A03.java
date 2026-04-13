import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_30680_XMLParser_A03 {

    private DefaultHandler handler = new DefaultHandler() {

        private boolean isName = false;
        private boolean isAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equals("name")) {
                isName = true;
            } else if (qName.equals("age")) {
                isAge = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            if (isName) {
                // Do something with the name
                isName = false;
            } else if (isAge) {
                // Do something with the age
                isAge = false;
            }
        }
    };

    public void parse(String filename) throws IOException, SAXException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(new File(filename), handler);
    }
}