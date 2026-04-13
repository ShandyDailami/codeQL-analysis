import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.StringReader;

public class java_00336_XMLParser_A07 {

    public static void main(String[] args) throws Exception {
        String xml = "<root>Hello World</root>";

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        MyHandler handler = new MyHandler();
        parser.parse(new StringReader(xml), handler);
    }

    static class MyHandler extends DefaultHandler {
        private String lastElementLocalName = null;
        private String lastElementValue = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            lastElementLocalName = localName;
        }

        @Override
        public void characters(char[] chars, int start, int length) throws SAXException {
            lastElementValue += new String(chars, start, length);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (localName.equals(lastElementLocalName)) {
                System.out.println("Element " + lastElementLocalName + " contains: " + lastElementValue);
            }
            lastElementLocalName = null;
            lastElementValue = null;
        }

        @Override
        public void startPrefixMapping(String prefix, String uri) throws SAXException {
            System.out.println("Prefix mapping: prefix = " + prefix + ", uri = " + uri);
        }

        @Override
        public void endPrefixMapping(String prefix) throws SAXException {
            System.out.println("End prefix mapping: prefix = " + prefix);
        }
    }
}