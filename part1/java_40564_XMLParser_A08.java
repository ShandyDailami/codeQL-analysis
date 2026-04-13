import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_40564_XMLParser_A08 {
    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser(null, new MyHandler());

        File xmlFile = new File("path/to/your/xml/file.xml");
        saxParser.parse(xmlFile, MyHandler.getDefaultHandler());
    }

    static class MyHandler extends DefaultHandler {
        private StringBuffer buffer;
        private String node;

        public java_40564_XMLParser_A08() {
            buffer = new StringBuffer();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            buffer.setLength(0);
            node = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            handleNode(qName, buffer.toString());
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            buffer.append(ch, start, length);
        }

        private void handleNode(String node, String content) {
            if (node.equals("tag") && content.equals("expected")) {
                // handle integrity failure here
                System.out.println("Security failure detected!");
            }
        }
    }
}