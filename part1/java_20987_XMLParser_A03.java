import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

public class java_20987_XMLParser_A03 {
    public void parse(String xmlFilePath) {
        try {
            File xmlFile = new File(xmlFilePath);
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(false);

            // Setting up the SAXHandler for XML parsing
            SaxHandler saxHandler = new SaxHandler();
            saxParser.parse(xmlFile, saxHandler);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Error parsing XML: " + e.getMessage());
        }
    }

    private class SaxHandler extends DefaultHandler {
        private boolean isTitle = false;
        private boolean isLink = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("title")) {
                isTitle = true;
            } else if (qName.equals("link")) {
                isLink = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isTitle) {
                System.out.println("Title: " + new String(ch, start, length));
                isTitle = false;
            } else if (isLink) {
                System.out.println("Link: " + new String(ch, start, length));
                isLink = false;
            }
        }
    }
}