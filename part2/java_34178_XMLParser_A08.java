import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_34178_XMLParser_A08 {
    private MyHandler handler;

    public static void main(String[] args) {
        String xmlFile = "sample.xml";  // replace with your actual XML file
        MyXMLParser parser = new MyXMLParser();
        parser.parse(xmlFile);
    }

    private void parse(String xmlFile) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new SAXHandler());
            parser.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class SAXHandler extends DefaultHandler {
        private boolean bName;
        private boolean bAge;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equals("person")) {
                bName = true;
                bAge = true;
            } else if (bName && qName.equals("name")) {
                bName = false;
            } else if (bName && qName.equals("age")) {
                bAge = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("person")) {
                bName = false;
                bAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName && bAge) {
                // here you can access the parsed data
                String name = new String(ch, start, length);
                // you can also access the age here
            }
        }
    }
}