import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_07815_XMLParser_A03 {

    public static class MySAXHandler extends DefaultHandler {

        private boolean bName = false;
        private boolean bAge = false;
        private boolean bCountry = false;
        private String tempValue;

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start Document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End Document");
        }

        @Override
        public void startElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                bName = true;
                bAge = true;
                bCountry = true;
            }
            if (qName.equalsIgnoreCase("name")) {
                bName = true;
            }
            if (qName.equalsIgnoreCase("age")) {
                bAge = true;
            }
            if (qName.equalsIgnoreCase("country")) {
                bCountry = true;
            }
        }

        @Override
        public java_07815_XMLParser_A03(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                System.out.println("Name: " + tempValue + ", Age: " + bAge + ", Country: " + bCountry);
                bName = false;
                bAge = false;
                bCountry = false;
            }
            if (qName.equalsIgnoreCase("name")) {
                bName = false;
            }
            if (qName.equalsIgnoreCase("age")) {
                bAge = false;
            }
            if (qName.equalsIgnoreCase("country")) {
                bCountry = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                tempValue = new String(ch, start, length);
            }
        }
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        MySAXHandler myHandler = new MySAXHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, myHandler);
        parser.parse(getClass().getResourceAsStream("/people.xml"), myHandler);
    }
}