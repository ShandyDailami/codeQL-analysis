import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_23585_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null, new CustomHandler());
            saxParser.parse(new File("path_to_your_xml_file.xml"), true);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    static class CustomHandler extends DefaultHandler {
        private boolean bName;
        private boolean bAge;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if (qName.equals("name")) {
                bName = true;
            } else if (qName.equals("age")) {
                bAge = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if (qName.equals("name")) {
                bName = false;
            } else if (qName.equals("age")) {
                bAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (bName) {
                // process the name
            } else if (bAge) {
                // process the age
            }
        }
    }
}