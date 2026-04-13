import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.XMLParser;

public class java_00504_XMLParser_A01 {

    public static void main(String[] args) {
        String fileName = "resources/sample.xml"; // replace with your xml file
        try {
            File file = new File(fileName);
            InputStream inputStream = new FileInputStream(file);

            SAXParser saxParser = org.xml.sax.pull.SAXParserFactory.newInstance().newSAXParser();
            MyHandler handler = new MyHandler();
            saxParser.parse(inputStream, handler);

            inputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private StringBuffer buffer = new StringBuffer();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            buffer.append("<").append(qName);
            for (int i = 0; i < attributes.getLength(); i++) {
                buffer.append(" ").append(attributes.getQName(i)).append("=\"").append(attributes.getValue(i)).append("\"");
            }
            buffer.append(">");
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            buffer.append("</").append(qName).append(">");
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            buffer.append(new String(ch, start, length));
        }

        @Override
        public void startPrefixMapping(String prefix, String uri) {
            buffer.append("<!PREFIX ").append(prefix).append("=\"").append(uri).append("\">");
        }

        @Override
        public void endPrefixMapping(String prefix) {
            buffer.append("</PREFIX>");
        }

        public String getContent() {
            return buffer.toString();
        }
    }
}