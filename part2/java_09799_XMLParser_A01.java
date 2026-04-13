import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_09799_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(true); // True for namespace support
            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("path/to/your/xml/file"), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private boolean bName;
        private boolean bAge;

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("person")) {
                bName = true;
                bAge = true;
                System.out.println("Person: " + attributes.getValue("name"));
            } else if (bName && qName.equals("name")) {
                System.out.println("Name: " + attributes.getValue(""));
                bName = false;
            } else if (bName && qName.equals("age")) {
                System.out.println("Age: " + attributes.getValue(""));
                bAge = false;
            }
        }

        @Override
        public java_09799_XMLParser_A01(String uri, String localName, String qName) throws SAXException {
            // Do nothing.
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bAge && qName.equals("age")) {
                System.out.println("Age: " + new String(ch, start, length));
            }
        }

        @Override
        public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
            // Do nothing.
        }

        @Override
        public void warning(SAXParseException e) throws SAXException {
            // Do nothing.
        }

        @Override
        public void error(SAXParseException e) throws SAXException {
            // Do nothing.
        }

        @Override
        public void fatalError(SAXParseException e) throws SAXException {
            // Do nothing.
        }
    }
}