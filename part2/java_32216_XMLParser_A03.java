import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;
import org.xml.sax.parser.XMLErrorHandler;

import java.io.File;
import java.io.IOException;

public class java_32216_XMLParser_A03 {

    public static void main(String[] args) {
        // Create a new instance of the XML parser
        XMLParser parser = new SAXParserImpl();

        // Load the XML file
        try {
            XMLLoader loader = new XMLLoader(new File("your_file.xml"));
            loader.setErrorHandler(new SAXErrorHandlerImpl());
            loader.parse(new File(args[0]));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Implement the SAX parser and handler
    static class SAXParserImpl extends XMLParser {
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
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End of element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }

    // Implement the SAX error handler
    static class SAXErrorHandlerImpl implements XMLErrorHandler {
        @Override
        public void fatalError(SAXException e) throws SAXException {
            System.out.println("Fatal error: " + e.getMessage());
        }

        @Override
        public void error(SAXException e) throws SAXException {
            System.out.println("Error: " + e.getMessage());
        }

        @Override
        public void warning(SAXException e) throws SAXException {
            System.out.println("Warning: " + e.getMessage());
        }

        @Override
        public void severeWarning(SAXException e) throws SAXException {
            System.out.println("Severe warning: " + e.getMessage());
        }
    }
}