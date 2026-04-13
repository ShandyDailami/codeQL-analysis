import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_36844_XMLParser_A03 {
    private static class MyHandler extends DefaultHandler {
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            // Your security-sensitive code here...
        }

        public void endElement(String uri, String localName, String qName) {
            // Your security-sensitive code here...
        }

        public void characters(char[] ch, int start, int length) {
            // Your security-sensitive code here...
        }
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser(true);

        MyHandler handler = new MyHandler();
        saxParser.parse(new File("sample.xml"), handler);
    }
}