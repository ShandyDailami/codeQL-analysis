import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_39857_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            File inputFile = new File("input.xml");
            parser.parse(inputFile, new SAXHandler());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private boolean elementName = false;
        private boolean elementContent = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            elementName = true;
            elementContent = false;
            System.out.println("Start element: " + qName);
        }

        @Override
        public void characters(char[] chars, int start, int length) {
            if (elementName) {
                elementName = false;
                System.out.print("Content: ");
                System.out.write(chars, start, length);
                System.out.println();
            } else {
                elementContent = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if (elementContent) {
                elementContent = false;
                System.out.println("End element: " + qName);
            }
        }
    }

    static class SAXHandler extends DefaultHandler {
        @Override
        public void startDocument() {
            System.out.println("Start document");
        }

        @Override
        public void endDocument() {
            System.out.println("End document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            System.out.println("Start element: " + qName);
        }

        @Override
        public void characters(char[] chars, int start, int length) {
            System.out.print("Content: ");
            System.out.write(chars, start, length);
            System.out.println();
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End element: " + qName);
        }
    }
}