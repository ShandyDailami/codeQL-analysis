import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_19600_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("src/main/resources/sample.xml");
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            // Use SAX to parse XML file
            MyHandler myHandler = new MyHandler();
            saxParser.setContentHandler(myHandler);
            xmlReader.setContentHandler(myHandler);

            saxParser.parse(xmlFile, myHandler);
            xmlReader.parse(xmlFile, myHandler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler implements org.xml.sax.helpers.DefaultHandler {

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of Document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of Document");
        }

        @Override
        public void startElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("Start of Element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End of Element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String content = new String(ch, start, length).trim();

            if (!content.isEmpty()) {
                System.out.println("Content: " + content);
            }
        }

        @Override
        public void fatalError(String error) throws SAXException {
            System.out.println("Fatal Error: " + error);
        }

        @Override
        public void warning(String msg) throws SAXException {
            System.out.println("Warning: " + msg);
        }
    }
}