import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_20449_XMLParser_A08 {

    public static void parseXML(String xml) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            MyHandler myHandler = new MyHandler();
            saxParser.parse(xml, myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private boolean bName;
        private boolean bId;
        private boolean bAge;
        private String tempValue;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("name")) {
                bName = true;
            } else if (qName.equalsIgnoreCase("id")) {
                bId = true;
            } else if (qName.equalsIgnoreCase("age")) {
                bAge = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                tempValue = new String(ch, start, length);
                bName = false;
            } else if (bId) {
                tempValue = new String(ch, start, length);
                bId = false;
            } else if (bAge) {
                tempValue = new String(ch, start, length);
                bAge = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                // Perform integrity checks
                if (tempValue == null || tempValue.isEmpty()) {
                    System.out.println("Integrity failure: All fields are missing in the XML document");
                } else {
                    System.out.println("Name: " + tempValue);
                    System.out.println("ID: " + tempValue);
                    System.out.println("Age: " + tempValue);
                }
            }
        }
    }
}