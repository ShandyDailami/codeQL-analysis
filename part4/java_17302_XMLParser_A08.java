import java.io.File;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_17302_XMLParser_A08 extends DefaultHandler {

    private SAXParser parser;
    private boolean integrityFailureDetected = false;

    public java_17302_XMLParser_A08() throws ParserConfigurationException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        parser = factory.newSAXParser(null, new SecurityHandler());
    }

    public void parse(File file) throws IOException, SAXException {
        parser.parse(file, this);
        if (integrityFailureDetected) {
            throw new SecurityException("Integrity failure detected during parsing");
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // No operation, as we don't care about element content
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // No operation, as we don't care about element content
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // No operation, as we don't care about element content
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        integrityFailureDetected = true;
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        // No operation
    }

    private class SecurityHandler extends DefaultHandler {

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // Ignore characters
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            // No operation, as we don't care about element content
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // No operation, as we don't care about element content
        }

        @Override
        public void fatalError(SAXParseException e) throws SAXException {
            // Do nothing
        }

        @Override
        public void warning(SAXParseException e) throws SAXException {
            // Do nothing
        }
    }
}