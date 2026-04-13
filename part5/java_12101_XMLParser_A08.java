import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.Xerces2DOMParser;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_12101_XMLParser_A08 {

    public static void main(String[] args) throws IOException, SAXException {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser(null);

        File xmlFile = new File("path/to/your/xml/file.xml");
        XMLParserHandler handler = new XMLParserHandler();

        sp.parse(xmlFile, handler);
    }

    static class XMLParserHandler extends DefaultHandler {
        private boolean bName;
        private boolean bAge;
        private String strName;
        private int iAge;

        @Override
        public void startElement(String uri, String localName, String qName,
                                org.xml.sax.Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("name")) {
                bName = true;
            }

            if (qName.equalsIgnoreCase("age")) {
                bAge = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            if (qName.equalsIgnoreCase("name")) {
                bName = false;
            }

            if (qName.equalsIgnoreCase("age")) {
                bAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            if (bName) {
                strName = new String(ch, start, length);
            }

            if (bAge) {
                iAge = Integer.parseInt(new String(ch, start, length));
            }
        }

        @Override
        public void endDocument() {
            System.out.println("Name: " + strName + ", Age: " + iAge);
        }
    }
}