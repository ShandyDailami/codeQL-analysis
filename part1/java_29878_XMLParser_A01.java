import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class java_29878_XMLParser_A01 {
    public void parse(String url) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            SAXParserHandler handler = new SAXParserHandler();
            reader.setContentHandler(handler);
            reader.parse(url);
            System.out.println("XML Document is well-formed and accessible.");
        } catch (Exception ex) {
            System.out.println("Error in parsing the XML document: " + ex.getMessage());
        }
    }

    private class SAXParserHandler extends DefaultHandler {
        public void startDocument() {
            System.out.println("Parsing a document...");
        }

        public void endDocument() {
            System.out.println("Finished parsing the document.");
        }

        public void startElement(String uri, String localName, String qName) {
            System.out.println("Starting element: " + qName);
        }

        public void endElement(String uri, String localName, String qName) {
            System.out.println("Ending element: " + qName);
        }

        public void characters(char[] ch, int start, int length) {
            System.out.println("Characters: " + new String(ch, start, length));
        }

        public void error(SAXException ex) {
            System.out.println("SAX Exception: " + ex.getMessage());
        }

        public void fatalError(SAXException ex) {
            System.out.println("Fatal SAX Exception: " + ex.getMessage());
        }
    }
}