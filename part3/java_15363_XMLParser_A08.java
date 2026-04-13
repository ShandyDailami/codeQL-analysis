import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_15363_XMLParser_A08 {

    public static void parse(String xmlFile) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
        saxParser.parse(xmlFile, new MyHandler());
    }

    static class MyHandler extends DefaultHandler {

        private boolean bName = false;
        private boolean bAge = false;
        private boolean bId = false;

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                System.out.println("Start of person : " + localName);
                bName = true;
                bAge = true;
                bId = true;
            }

            if (qName.equalsIgnoreCase("name")) {
                System.out.println("Start of name");
                bName = true;
            }

            if (qName.equalsIgnoreCase("age")) {
                System.out.println("Start of age");
                bAge = true;
            }

            if (qName.equalsIgnoreCase("id")) {
                System.out.println("Start of id");
                bId = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                System.out.println("End of person : " + localName);
                bName = false;
                bAge = false;
                bId = false;
            }

            if (qName.equalsIgnoreCase("name")) {
                System.out.println("End of name");
                bName = false;
            }

            if (qName.equalsIgnoreCase("age")) {
                System.out.println("End of age");
                bAge = false;
            }

            if (qName.equalsIgnoreCase("id")) {
                System.out.println("End of id");
                bId = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                System.out.println("Name: " + new String(ch, start, length));
            }

            if (bAge) {
                System.out.println("Age: " + new String(ch, start, length));
            }

            if (bId) {
                System.out.println("Id: " + new String(ch, start, length));
            }
        }

    }
}