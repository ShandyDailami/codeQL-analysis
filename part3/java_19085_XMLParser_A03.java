import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_19085_XMLParser_A03 {
    public static class MyHandler extends DefaultHandler {
        private StringBuffer buffer;
        private String element;
        private String content;

        public java_19085_XMLParser_A03() {
            buffer = new StringBuffer();
        }

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            buffer.setLength(0);
            element = localName;
            content = "<" + localName + ">";
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            content += buffer.toString();
            content += "</" + localName + ">";
            System.out.println(element + ": " + content);
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            buffer.append(ch, start, length);
        }
    }

    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        MyHandler handler = new MyHandler();
        parser.parse("src/test.xml", handler);
    }
}