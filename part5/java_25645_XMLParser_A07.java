import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_25645_XMLParser_A07 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("resources/sample.xml"), true);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        private boolean isName = false;
        private boolean isValue = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("name")) {
                isName = true;
            } else if (qName.equalsIgnoreCase("value")) {
                isValue = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isName) {
                String name = new String(ch, start, length);
                System.out.println("Name: " + name);
                isName = false;
            } else if (isValue) {
                String value = new String(ch, start, length);
                System.out.println("Value: " + value);
                isValue = false;
            }
        }
    }
}