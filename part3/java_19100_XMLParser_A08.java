import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_19100_XMLParser_A08 {

    public static void parseXml(String xmlFile) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(xmlFile, myHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Define a handler for SAX parsing
    static class MyHandler extends DefaultHandler {

        boolean bName = false;
        boolean bAge = false;

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
            if (qName.equals("person")) {
                System.out.println("Start Element: " + qName);
                bName = true;
                bAge = true;
            } else if (bName && qName.equals("name")) {
                System.out.println("Start Element: " + qName);
            } else if (bName && qName.equals("age")) {
                System.out.println("Start Element: " + qName);
                bAge = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("name")) {
                bName = false;
            } else if (qName.equals("age")) {
                bAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName && bAge) {
                String s = new String(ch, start, length);
                System.out.println("Character Data: " + s);
                bAge = false;
            }
        }

    }

    public static void main(String[] args) {
        String xmlFile = "sample.xml";
        parseXml(xmlFile);
    }

}