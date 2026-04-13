import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXParserFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParser;
import java.io.File;
import java.io.IOException;

public class java_41839_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            MyHandler handler = new MyHandler();
            XMLReader reader = parser.getXMLReader();
            reader.setContentHandler(handler);
            reader.parse(new File("test.xml"));
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public static class MyHandler extends DefaultHandler {

        private StringBuilder buffer;

        public java_41839_XMLParser_A03() {
            buffer = new StringBuilder();
        }

        @Override
        public void startElement(String uri, String localName, String qName,
                                 org.xml.sax.Attributes attributes) throws SAXException {
            buffer.setLength(0);
            buffer.append(qName);
            System.out.println("Start Element: " + buffer.toString());
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            buffer.setLength(0);
            buffer.append(qName);
            System.out.println("End Element: " + buffer.toString());
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            buffer.append(ch, start, length);
            System.out.println("Characters: " + buffer.toString());
        }
    }
}