import java.io.File;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_00561_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlFile = "src/main/resources/books.xml";
        parseXMLFile(xmlFile);
    }

    public static void parseXMLFile(String xmlFile) {
        try {
            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
            saxParser.setXMLReader(newSAXReader());

            MyHandler myHandler = new MyHandler();
            saxParser.parse(xmlFile, myHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static XMLReader newSAXReader() {
        return XMLReaderFactory.createXMLReader();
    }

    private static class MyHandler extends DefaultHandler {
        @Override
        public void startDocument() throws SAXException {
            System.out.println("Parsing an XML document.");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("Start element: " + qName);
            printAttributes(attributes);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End element: " + qName);
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("Finished parsing the XML document.");
        }

        private void printAttributes(Attributes attributes) {
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.println("Attribute: " + attributes.getQName(i) + " = " + attributes.getValue(i));
            }
        }

        @Override
        public void warning(SAXParseException e) {
            System.out.println("Warning: " + e.getMessage());
        }

        @Override
        public void error(SAXParseException e) {
            System.out.println("Error: " + e.getMessage());
        }

        @Override
        public void fatalError(SAXParseException e) {
            System.out.println("Fatal Error: " + e.getMessage());
        }
    }
}