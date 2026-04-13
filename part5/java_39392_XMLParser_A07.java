import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestException;

import sun.security.x509.X509Certificate;
import sun.security.x509.X509dn;

public class java_39392_XMLParser_A07 {

    public static void main(String[] args) {
        parseXML("sample.xml");
    }

    public static void parseXML(String fileName) {
        try {
            FileInputStream fis = new FileInputStream(fileName);

            // Create an instance of the XMLParser
            javax.xml.parsers.ParserConfigurationException pce = null;
            org.xml.sax.SAXException saxException = null;
            org.xml.sax.SAXParseException saxParseException = null;
            org.w3c.dom.Document document = null;

            // Create an instance of the XMLReader
            javax.xml.parsers.SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            org.xml.sax.SAXParser saxParser = saxParserFactory.newSAXParser(null);

            // Create an instance of the Handler
            MyHandler handler = new MyHandler();

            // Set the ContentHandler
            saxParser.setContentHandler(handler);

            // Parse the XML file
            saxParser.parse(fis, null);

            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // MyHandler class
    static class MyHandler extends DefaultHandler {

        @Override
        public void startDocument(Document uri, String encoding, InputSource in) {
            System.out.println("XML Document Start");
        }

        @Override
        public void endDocument(Document arg0) {
            System.out.println("XML Document End");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("Start Element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End Element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Character Data: " + new String(ch, start, length));
        }
    }
}