import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_08539_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
            saxParser.parse(new File("sample.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private StringBuilder content;
        private boolean elementContent;

        public java_08539_XMLParser_A01() {
            content = new StringBuilder();
            elementContent = false;
        }

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
            System.out.println("Start of element: " + qName);
            elementContent = true;
            content.append("<" + qName + ">");
        }

        @Override
        public java_08539_XMLParser_A01(String uri, String localName, String qName) throws SAXException {
            System.out.println("End of element: " + qName);
            elementContent = false;
            content.append("</" + qName + ">");
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (elementContent) {
                content.append(new String(ch, start, length));
            }
        }

        @Override
        public void startPrefixMapping(String prefix, String uri) throws SAXException {
            System.out.println("Start of prefix mapping: " + prefix + ", " + uri);
        }

        @Override
        public void endPrefixMapping(String prefix, String uri) throws SAXException {
            System.out.println("End of prefix mapping: " + prefix + ", " + uri);
        }
    }
}