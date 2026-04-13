import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

import java.io.File;
import java.io.IOException;

public class java_37741_XMLParser_A08 {

    private static class MyHandler extends DefaultHandler {

        private String lastTagName;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            lastTagName = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (isAwesome(qName)) {
                System.out.println("Warning: The XML file contains a security-sensitive operation!");
            }
            lastTagName = null;
        }

        private boolean isAwesome(String qName) {
            // Here you can add your logic to identify security-sensitive operations.
            // For the example, let's assume that all tags with the name "awesome" will trigger a warning.
            return "awesome".equals(qName);
        }
    }

    public static void parse(String filePath) throws IOException, SAXException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new MyHandler());
        parser.parse(new File(filePath));
    }

    public static void main(String[] args) throws IOException, SAXException {
        parse("sample.xml"); // replace with your file path
    }
}