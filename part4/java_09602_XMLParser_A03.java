import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.SAXParseException;

import java.io.File;
import java.io.IOException;

public class java_09602_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "src/main/resources/injection_test.xml";

        try {
            File xmlFileToParse = new File(xmlFile);
            SAXReader saxReader = new SAXReader();

            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(new SAXContentHandler(saxReader));

            xmlReader.parse(xmlFileToParse);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static class SAXContentHandler implements org.xml.sax.ContentHandler {

        private SAXReader saxReader;

        public java_09602_XMLParser_A03(SAXReader saxReader) {
            this.saxReader = saxReader;
        }

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of Document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of Document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
            System.out.println("Start Element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End Element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String str = new String(ch, start, length);
            System.out.println("Character Data: " + str);
        }

        @Override
        public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
            System.out.println("Ignorable Whitespace: " + new String(ch, start, length));
        }

        @Override
        public void warning(SAXParseException e) throws SAXException {
            System.out.println("Warning: " + e.getMessage());
        }

        @Override
        public void error(SAXParseException e) throws SAXException {
            System.out.println("Error: " + e.getMessage());
        }

        @Override
        public void fatalError(SAXParseException e) throws SAXException {
            System.out.println("Fatal Error: " + e.getMessage());
        }
    }
}