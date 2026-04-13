import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_33012_XMLParser_A08 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        MyHandler handler = new MyHandler();

        try {
            parser.parse(new File("input.xml"), handler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private boolean isElement = false;
        private String currentElement;
        private String currentAttribute;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            isElement = true;
            currentElement = qName;
            currentAttribute = "";
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            isElement = false;
            currentElement = "";
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isElement) {
                String value = new String(ch, start, length);
                if (!currentAttribute.isEmpty()) {
                    currentAttribute += "='" + value + "'";
                } else {
                    currentAttribute = value;
                }
            }
        }

        @Override
        public void warning(SAXParseException e) {
            System.out.println("SAX Parsing Warning: " + e.getMessage());
        }

        @Override
        public void error(SAXParseException e) {
            System.out.println("SAX Parsing Error: " + e.getMessage());
        }

        @Override
        public void fatalError(SAXParseException e) {
            System.out.println("SAX Parsing Fatal Error: " + e.getMessage());
        }
    }
}