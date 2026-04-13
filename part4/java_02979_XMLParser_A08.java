import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_02979_XMLParser_A08 {

    // Our handler
    private class MyHandler extends DefaultHandler {
        private boolean bTag = false;
        private String thisElement = "";

        // Called for the root element
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            thisElement = qName;
        }

        // Called for each element encountered by the parser
        @Override
        public void startElement(String uri, String localName, String qName) throws SAXException {
            thisElement = qName;
        }

        // Called for the attributes of the element
        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bTag) {
                String content = new String(ch, start, length);
                System.out.println(thisElement + ": " + content);
            }
        }

        // Called for the closing tag
        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            thisElement = qName;
            bTag = false;
        }

        // Called for the character data
        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // Not used in this example
        }
    }

    public void parse(String filename) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        MyHandler handler = new MyHandler();
        parser.parse(filename, handler);
    }

    public static void main(String[] args) {
        try {
            new XmlSaxParser().parse("sample.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}