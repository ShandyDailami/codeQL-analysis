import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLErrorHandler;
import org.xml.sax.parser.XMLEventHandler;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLScanner;
import org.xml.sax.xmlreader.XMLReaderImpl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class java_40526_XMLParser_A01 {

    private XMLEventHandler eventHandler = new XMLEventHandler() {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            // This method will be called for each start element.
            // You can add your logic here.
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // This method will be called for each end element.
            // You can add your logic here.
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // This method will be called for each character data.
            // You can add your logic here.
        }
    };

    private XMLErrorHandler errorHandler = new XMLErrorHandler() {
        @Override
        public void fatalError(String error) throws SAXException {
            // You can add your logic for fatal error here.
        }

        @Override
        public void warning(String msg) throws SAXException {
            // You can add your logic for warning here.
        }

        @Override
        public void error(SAXParseException e) throws SAXException {
            // You can add your logic for error here.
        }

        @Override
        public void fatalError(String message, SAXParseException e) throws SAXException {
            // You can add your logic for fatalError here.
        }
    };

    public void parse(String xmlFilePath) {
        try {
            XMLReader xmlReader = XMLReaderImpl.forInstance(new File(xmlFilePath));
            xmlReader.setContentHandler(eventHandler);
            xmlReader.setErrorHandler(errorHandler);
            xmlReader.parse(new SAXSource(xmlReader));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}