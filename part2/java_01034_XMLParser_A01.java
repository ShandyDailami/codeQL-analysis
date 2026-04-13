import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_01034_XMLParser_A01 {

    public static class MyHandler extends DefaultHandler {

        private String currElement;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            currElement = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            currElement = null;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (currElement != null) {
                System.out.println(currElement + ": " + new String(ch, start, length));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, MyHandler.class);

        // Load the XML document
        parser.parse("src/input.xml", true);
    }
}