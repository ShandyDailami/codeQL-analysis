import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_10933_XMLParser_A08 {

    public static class MyHandler extends DefaultHandler {

        private StringBuilder data = new StringBuilder();
        private boolean tagName = false;

        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            tagName = true;
            data.setLength(0);
        }

        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            if (tagName) {
                System.out.println(qName + " : " + data.toString());
                tagName = false;
            }
        }

        public void characters(char[] ch, int start, int length)
                throws SAXException {
            if (tagName) {
                data.append(new String(ch, start, length));
            }
        }

    }

    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        MyHandler handler = new MyHandler();
        parser.parse(XmlParser.class.getResourceAsStream("/sample.xml"), handler);
    }
}