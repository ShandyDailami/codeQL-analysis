import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_31751_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            File inputFile = new File("src/input.xml");
            parser.parse(inputFile, new SAXHandler());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private StringBuilder sb;
        private boolean elementNameFound;

        @Override
        public void startDocument() {
            sb = new StringBuilder();
            elementNameFound = false;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            elementNameFound = true;
            sb.append(localName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            elementNameFound = false;
            sb.append("/");
            sb.append(localName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if(elementNameFound) {
                sb.append(new String(ch, start, length));
            }
        }
    }

    static class SAXHandler extends DefaultHandler {
        public void startDocument() {
            System.out.println("Document Started");
        }

        public void endDocument() {
            System.out.println("Document Ended");
        }

        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            System.out.print("Element Started : ");
            System.out.println(localName);
        }

        public void endElement(String uri, String localName, String qName) {
            System.out.print("Element Ended : ");
            System.out.println(localName);
        }

        public void characters(char[] ch, int start, int length) {
            System.out.print("Characters : ");
            System.out.println(new String(ch, start, length));
        }
    }
}