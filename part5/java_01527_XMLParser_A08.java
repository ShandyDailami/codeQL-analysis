import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_01527_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFile = "your_xml_file_path.xml";

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null);

        XMLHandler handler = new XMLHandler();
        parser.parse(xmlFile, handler);
    }

    static class XMLHandler extends DefaultHandler {

        private boolean bTag = false;
        private String currentElement = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            currentElement = qName;
            bTag = true;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            bTag = false;
            currentElement = "";
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bTag) {
                System.out.println(currentElement + " : " + new String(ch, start, length));
            }
        }
    }
}