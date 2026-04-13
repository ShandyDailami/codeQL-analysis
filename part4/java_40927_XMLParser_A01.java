import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_40927_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true); // Use true to get full namespace support
            saxParser.parse(new File("input.xml"), new XmlHandler()); // Replace "input.xml" with your XML file
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class XmlHandler implements javax.xml.parsers.SAXHandler {

        @Override
        public void startElement(String uri, String localName, String qName, javax.xml.parsers.Attributes attributes) {
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}