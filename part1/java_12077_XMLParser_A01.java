import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_12077_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            MyHandler myHandler = new MyHandler();
            saxParser.parse("src/main/resources/sample.xml", myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        private boolean bName = false;
        private boolean bAge = false;
        private boolean bCity = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                bName = true;
                bAge = true;
                bCity = true;
            } else if (bName && qName.equalsIgnoreCase("name")) {
                // Breakpoint
            } else if (bAge && qName.equalsIgnoreCase("age")) {
                // Breakpoint
            } else if (bCity && qName.equalsIgnoreCase("city")) {
                // Breakpoint
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                bName = false;
                bAge = false;
                bCity = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                // Print the name of the person
            } else if (bAge) {
                // Print the age of the person
            } else if (bCity) {
                // Print the city of the person
            }
        }
    }
}