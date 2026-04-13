import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXHelper;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_28452_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();

            // Create a custom handler
            MyHandler myHandler = new MyHandler();

            // Parse the XML file
            saxParser.parse(new File("path_to_your_file.xml"), myHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            // If auth failure tag found
            if (qName.equalsIgnoreCase("authFailure")) {
                throw new SAXException("Authentication failure detected!");
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            // Do nothing
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            // Do nothing
        }
    }
}