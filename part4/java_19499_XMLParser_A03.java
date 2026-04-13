import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;

public class java_19499_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "src/test.xml";  // test.xml should be placed in the same directory as your compiled Java file
        parseXml(xmlFile);
    }

    private static void parseXml(String xmlFile) {
        XMLParser parser = new XMLParser();
        try {
            XMLLoader loader = new XMLLoader(new FileInputStream(new File(xmlFile)));
            loader.setContentHandler(parser);
            loader.parse(new InputStreamReader(new FileInputStream(new File(xmlFile)), parser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class SaxHandler extends DefaultHandler {

        private boolean bName = false;
        private boolean bValue = false;
        private String currentElement = null;

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentElement = qName;
            bName = true;
            bValue = false;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            currentElement = null;
            bName = false;
            bValue = true;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                System.out.println("Element: " + currentElement + ", Value: " + new String(ch, start, length));
            }
        }

    }
}