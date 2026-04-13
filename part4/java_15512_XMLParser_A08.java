import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_15512_XMLParser_A08 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(XmlParser.class.getResourceAsStream("/sample.xml"), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        private boolean bName;
        private boolean bAge;
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
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                System.out.println("Start Person");
                bName = true;
                bAge = true;
            } else if (qName.equalsIgnoreCase("name")) {
                System.out.println("Start Name");
                bName = true;
            } else if (qName.equalsIgnoreCase("age")) {
                System.out.println("Start Age");
                bAge = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                System.out.println("End Person");
                bName = false;
                bAge = false;
            } else if (qName.equalsIgnoreCase("name")) {
                System.out.println("End Name: " + tempValue);
                bName = false;
            } else if (qName.equalsIgnoreCase("age")) {
                System.out.println("End Age: " + tempValue);
                bAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                tempValue = new String(ch, start, length);
                System.out.println("Name: " + tempValue);
            } else if (bAge) {
                tempValue = new String(ch, start, length);
                System.out.println("Age: " + tempValue);
            }
        }

    }
}