import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_39084_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFile = "src/test.xml";
        parseFile(xmlFile);
    }

    public static void parseFile(String xmlFile) {
        File file = new File(xmlFile);
        SAXParser saxParser = null;

        try {
            saxParser = SAXParserFactory.newInstance().newSAXParser();
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }

        XMLReader xmlReader = null;
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
        } catch (IOException e) {
            e.printStackTrace();
        }

        MyHandler myHandler = new MyHandler();

        try {
            xmlReader.setContentHandler(myHandler);
            xmlReader.parse(file);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private boolean isPerson;
        private String personName;

        @Override
        public void startDocument() throws SAXException {
            isPerson = false;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                isPerson = true;
                personName = "";
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                isPerson = false;
                System.out.println(personName);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isPerson) {
                personName = new String(ch, start, length);
            }
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of document.");
        }

        @Override
        public void warning(SAXParseException e) {
            System.out.println("Warning: " + e.getMessage());
        }

        @Override
        public void error(SAXParseException e) {
            System.out.println("Error: " + e.getMessage());
        }

        @Override
        public void fatalError(SAXParseException e) {
            System.out.println("Fatal Error: " + e.getMessage());
        }
    }
}