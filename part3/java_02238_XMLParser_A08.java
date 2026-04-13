import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XPDA_StreamCapabilities;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Stack;

public class java_02238_XMLParser_A08 {
    public static class MyHandler extends DefaultHandler {
        private Stack<String> stack = new Stack<>();

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println(indentation() + qName);
            stack.push(qName);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            stack.pop();
            System.out.println(indentation() + qName);
        }

        private String indentation() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < stack.size(); i++) {
                sb.append("--");
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream("example.xml");
            XMLParser parser = XMLParser.newInstance("org.apache.xerces.parsers.SAXParser", true, true);
            MyHandler handler = new MyHandler();
            parser.setContentHandler(handler);
            parser.parse(new XPDA_StreamCapabilities(inputStream));
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}