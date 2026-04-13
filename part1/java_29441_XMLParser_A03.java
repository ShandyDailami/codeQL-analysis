import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_29441_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        MyHandler handler = new MyHandler();
        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(handler);

        try {
            parser.parse(new File("sample.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bName = false;
        boolean bAge = false;

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                System.out.println("Start Person: " + localName);
                bName = true;
                bAge = true;
            } else if (bName && qName.equalsIgnoreCase("name")) {
                System.out.println("Start Name: " + localName);
                bName = false;
            } else if (bName && qName.equalsIgnoreCase("age")) {
                System.out.println("Start Age: " + localName);
                bAge = false;
            } else if (bAge && qName.equalsIgnoreCase("age")) {
                System.out.println("Age: " + localName);
                bAge = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                System.out.println("End Person: " + localName);
            } else if (bName && qName.equalsIgnoreCase("name")) {
                System.out.println("End Name: " + localName);
                bName = false;
            } else if (bAge && qName.equalsIgnoreCase("age")) {
                System.out.println("End Age: " + localName);
                bAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName || bAge) {
                System.out.println("Characters: " + new String(ch, start, length));
            }
        }
    }
}