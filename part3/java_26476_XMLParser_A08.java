import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_26476_XMLParser_A08 {

    public static void parseXML(String xmlFilePath) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new SAXHandler());
            saxParser.parse(xmlFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class SAXHandler extends DefaultHandler {
        boolean bIsStartElement = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            bIsStartElement = true;
            System.out.println("Start element: " + localName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            bIsStartElement = false;
            System.out.println("End element: " + localName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bIsStartElement) {
                System.out.println("Characters: " + new String(ch, start, length));
            }
        }
    }

    public static void main(String[] args) {
        parseXML("sample.xml");
    }
}