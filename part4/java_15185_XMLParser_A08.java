import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_15185_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            saxParser.parse(new File("input.xml"), new MyHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private StringBuilder buffer = new StringBuilder();
        private String elementName;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            elementName = qName;
            buffer.setLength(0);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            buffer.append(ch, start, length);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (elementName.equals(qName)) {
                System.out.println(elementName + ": " + buffer.toString());
            } else {
                System.out.println("Element: " + elementName + " with value: " + buffer.toString());
            }
            elementName = null;
        }
    }
}