import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_26332_XMLParser_A08 {

    public static class MyHandler extends DefaultHandler {
        private boolean bName;
        private boolean bAge;
        private String tempValue;

        public java_26332_XMLParser_A08() {
            bName = bAge = false;
        }

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
                bName = true;
                bAge = true;
            } else if (bName && qName.equalsIgnoreCase("name")) {
                bName = false;
                System.out.println("Name : " + tempValue);
            } else if (bAge && qName.equalsIgnoreCase("age")) {
                bAge = false;
                System.out.println("Age : " + tempValue);
            }
            tempValue = "";
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                System.out.println("End Person");
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            tempValue = new String(ch, start, length);
        }
    }

    public static void main(String[] args) throws Exception {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(null);
        MyHandler myHandler = new MyHandler();
        saxParser.parse(XmlSAXParser.class.getResourceAsStream("sample.xml"), myHandler);
    }
}