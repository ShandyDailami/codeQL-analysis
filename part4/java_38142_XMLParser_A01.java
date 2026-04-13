import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_38142_XMLParser_A01 {

    public static void main(String[] args) throws Exception {
        File inputFile = new File("input.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        SAXParser saxParser = saxParserFactory.newSAXParser(null);

        // Handler is the object that will process the parsed XML data
        MyHandler myHandler = new MyHandler();

        // Parse the input file
        saxParser.parse(inputFile, myHandler);
    }

    static class MyHandler extends DefaultHandler {

        private boolean bName;
        private boolean bAge;
        private String currentElement;

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qualifiedName, Attributes attributes) throws SAXException {
            currentElement = qualifiedName;

            if (localName.equals("person")) {
                bName = true;
                bAge = true;
            } else {
                if (localName.equals("name")) {
                    bName = true;
                } else if (localName.equals("age")) {
                    bAge = true;
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qualifiedName) throws SAXException {
            currentElement = null;

            if (localName.equals("person")) {
                bName = false;
                bAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                System.out.println("Name: " + new String(ch, start, length));
                bName = false;
            } else if (bAge) {
                System.out.println("Age: " + new String(ch, start, length));
                bAge = false;
            }
        }

        @Override
        public void fatalError(SAXParseException e) throws SAXException {
            System.out.println("Fatal Error: " + e.getMessage());
        }

        @Override
        public void warning(SAXParseException e) throws SAXException {
            System.out.println("Warning: " + e.getMessage());
        }
    }
}