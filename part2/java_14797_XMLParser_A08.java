import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XSLTProcessor;

import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class java_14797_XMLParser_A08 {

    public static void main(String[] args) throws Exception {
        // Create a SAXParserFactory
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        // Create a SAXParser using the factory
        SAXParser saxParser = saxParserFactory.newSAXParser(new DTDHandler());

        // Parse the input source
        InputStream inputStream = new FileInputStream(new File("example.xml"));
        saxParser.parse(inputStream, new DTDHandler());
    }

    // Handler for SAX events
    static class DTDHandler extends DefaultHandler {

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
            String content = new String(ch, start, length);
            System.out.println("Character data: " + content);
        }
    }
}