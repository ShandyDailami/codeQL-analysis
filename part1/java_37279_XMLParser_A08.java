import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParser;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_37279_XMLParser_A08 {

    public static void main(String[] args) {
        String filePath = "path_to_your_xml_file.xml";
        parse(filePath);
    }

    private static void parse(String filePath) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File(filePath));
        } catch (SAXParseException e) {
            System.err.println("Parsing error at line: " + e.getLineNumber());
            e.printStackTrace(System.err);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {

        private boolean bName = false;
        private boolean bAge = false;
        private String name = null;
        private String age = null;

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
            if (qName.equalsIgnoreCase("person")) {
                bName = true;
                bAge = true;
            } else if (bName) {
                if (qName.equalsIgnoreCase("name")) {
                    bName = false;
                }
            } else if (bAge) {
                if (qName.equalsIgnoreCase("age")) {
                    bAge = false;
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                System.out.println("Person name: " + name);
                System.out.println("Person age: " + age);
                bName = false;
                bAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                name = new String(ch, start, length);
            } else if (bAge) {
                age = new String(ch, start, length);
            }
        }

    }
}