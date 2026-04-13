// A simple XML parser example program

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXHandler;

public class java_36393_XMLParser_A01 {

    private static class MySAXHandler extends SAXHandler {
        public void startElement(String uri, String localName, String qName,
                Attributes attributes) throws SAXException {
            System.out.println("Start Element: " + qName);
        }

        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            System.out.println("End Element: " + qName);
        }

        public void characters(char[] ch, int start, int length)
                throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(false);
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(new MySAXHandler());
            xmlReader.parse("src/main/resources/test.xml");
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }
}