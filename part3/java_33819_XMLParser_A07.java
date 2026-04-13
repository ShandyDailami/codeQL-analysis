import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_33819_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            // SAX
            DefaultHandler defaultHandler = new DefaultHandler() {
                boolean bTag = false;
                String strData = null;
                String strAttribute = null;

                @Override
                public void startDocument() throws SAXException {
                    System.out.println("Start Document");
                }

                @Override
                public void endDocument() throws SAXException {
                    System.out.println("End Document");
                }

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    System.out.println("Start Element: " + qName);
                    bTag = true;
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("End Element: " + qName);
                    bTag = false;
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    if (bTag) {
                        strData = new String(ch, start, length);
                        System.out.println("Character Data: " + strData);
                    }
                }
            };

            // Parse XML file
            saxParser.parse(new File("input.xml"), defaultHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}