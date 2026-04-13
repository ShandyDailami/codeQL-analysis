import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_10256_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("sample.xml"), true); // parse file
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private StringBuilder buffer;
        private String tagName;

        @Override
        public void startDocument() {
            buffer = new StringBuilder();
        }

        @Override
        public void endDocument() {
            System.out.println(buffer.toString());
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            tagName = qName;
            buffer.append("<").append(qName);
            for (int i = 0; i < attributes.getLength(); i++) {
                buffer.append(" ").append(attributes.getQName(i)).append("=\"").append(attributes.getValue(i)).append("\"");
            }
            buffer.append(">");
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            buffer.append("</").append(qName).append(">");
            System.out.println(buffer.toString());
            buffer.setLength(0);
            tagName = null;
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (tagName != null) {
                buffer.append(new String(ch, start, length));
            }
        }
    }
}