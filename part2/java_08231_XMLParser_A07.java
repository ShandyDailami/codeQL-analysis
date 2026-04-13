import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;

public class java_08231_XMLParser_A07 {

    public static void main(String[] args) {
        // Creating the XML parser
        XMLParser parser = new XMLParserImpl();

        // Parsing the XML file
        try {
            parser.parse(new File("input.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Implementing the XMLParser interface
    private static class XMLParserImpl implements XMLParser {

        private XMLReader reader;

        public java_08231_XMLParser_A07() {
            // Creating a new SAX Reader
            reader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            reader.setContentHandler(new ContentHandlerImpl());
        }

        @Override
        public void parse(File file) throws Exception {
            // Parsing the XML file
            reader.parse(new InputSource(new FileInputStream(file)));
        }

        // Implementing the methods of the ContentHandler interface
        private static class ContentHandlerImpl implements ContentHandler {

            @Override
            public void startDocument() throws SAXException {
                // Do nothing
            }

            @Override
            public void endDocument() throws SAXException {
                // Do nothing
            }

            @Override
            public void startElement(String uri, String localName, String qualifiedName, Attributes attributes) throws SAXException {
                // Do nothing
            }

            @Override
            public void endElement(String uri, String localName, String qualifiedName) throws SAXException {
                // Do nothing
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                // Do nothing
            }

            @Override
            public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
                // Do nothing
            }

            @Override
            public void processingInstruction(String target, String data) throws SAXException {
                // Do nothing
            }

            @Override
            public void endPrefixMapping(String prefix) throws SAXException {
                // Do nothing
            }
        }
    }
}