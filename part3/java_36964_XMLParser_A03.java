import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParserFactory;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.StringReader;
import java.io.IOException;
import java.net.URL;

public class java_36964_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.com/sample.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            XMLReader reader = XMLReaderFactory.createXMLReader(factory);
            reader.setContentHandler(new ContentHandler());
            reader.parse(url.openStream());
        } catch (IOException | SAXParseException e) {
            e.printStackTrace();
        }
    }

    static class ContentHandler extends DefaultHandler {
        private StringBuilder sb = new StringBuilder();

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String namespaceURI, String localName, String qualifiedName, Attributes atts) throws SAXException {
            System.out.println("Start of element: " + localName);
            sb.setLength(0);
        }

        @Override
        public void endElement(String namespaceURI, String localName, String qualifiedName) throws SAXException {
            System.out.println("End of element: " + localName);
            System.out.println("Element content: " + sb.toString());
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
            sb.append(new String(ch, start, length));
        }

        @Override
        public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
            System.out.println("Ignorable whitespace: " + new String(ch, start, length));
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