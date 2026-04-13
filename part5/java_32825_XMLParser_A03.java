import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.io.StringReader;
import java.security.NoSuchAlgorithmException;

public class java_32825_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            SecuritySensitiveOperations o = new SecuritySensitiveOperations();
            o.parseXML("<note>You don't know JS</note>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parseXML(String xmlString) throws NoSuchAlgorithmException, IOException, SAXException {
        // a. The XMLReader should be a unique instance of XMLReader.
        XMLReader reader = XMLReaderFactory.createXMLReader();

        // b. Security-sensitive operations are the ones that deal with the XMLReader.
        reader.setContentHandler(new XMLContentHandler());
        reader.parse(new StringReader(xmlString));
    }

    private class XMLContentHandler implements org.xml.sax.ContentHandler {

        // c. Security-sensitive operations are always inside the ContentHandler.
        @Override
        public void startDocument() throws SAXException {
            // d. Start operations here.
        }

        @Override
        public void endDocument() throws SAXException {
            // d. End operations here.
        }

        @Override
        public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
            // d. Start operations here.
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // d. End operations here.
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // d. Characters operations here.
        }

        @Override
        public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
            // d. Ignorable whitespace operations here.
        }
    }
}