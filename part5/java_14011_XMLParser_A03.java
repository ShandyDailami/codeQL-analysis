import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

public class java_14011_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(true);

        DefaultHandler defaultHandler = new DefaultHandler() {
            public void startDocument() throws SAXException {
                System.out.println("Start of document");
            }

            public void endDocument() throws SAXException {
                System.out.println("End of document");
            }

            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                System.out.println("Start of element: " + qName);
            }

            public void endElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("End of element: " + qName);
            }

            public void characters(char[] ch, int start, int length) throws SAXException {
                System.out.println("Characters: " + new String(ch, start, length));
            }
        };

        File xmlFile = new File("sample.xml");
        if (!xmlFile.exists()) {
            System.out.println("XML file not found!");
            return;
        }

        try {
            saxParser.parse(new FileInputStream(xmlFile), defaultHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}