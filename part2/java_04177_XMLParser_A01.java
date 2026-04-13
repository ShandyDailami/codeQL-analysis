import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_04177_XMLParser_A01 {

    // Inner class that implements the SAX interface
    private class MyHandler extends DefaultHandler {
        private boolean accessControl = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("access")) {
                accessControl = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("access")) {
                accessControl = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (accessControl) {
                String str = new String(ch, start, length);
                // Check if the string contains a sensitive operation
                if (str.contains("access_control")) {
                    System.out.println("Broken access control detected: " + str);
                }
            }
        }
    }

    public void parseXML(String xmlFile) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new MyHandler());
        parser.parse(new File(xmlFile));
    }

    public static void main(String[] args) {
        SecurityVanillaXMLParser parser = new SecurityVanillaXMLParser();
        parser.parseXML("example.xml");
    }
}