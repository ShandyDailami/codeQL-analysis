import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;
import org.xml.sax.parser.XMLErrorHandler;

import java.io.File;
import java.io.IOException;

public class java_20051_XMLParser_A01 {
    public static void main(String[] args) {
        String xmlFile = "path/to/your/xml/file.xml";
        parseXml(xmlFile);
    }

    public static void parseXml(String xmlFile) {
        XMLLoader loader = new XMLLoader();
        loader.setErrorHandler(new MyErrorHandler());
        XMLParser parser = loader.getParser();

        try {
            parser.setEntityResolver(new MyEntityResolver());
            parser.parse(xmlFile, new MyContentHandler());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Handlers
    private static class MyContentHandler extends DefaultHandler {
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
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Character data: " + new String(ch, start, length));
        }
    }

    private static class MyErrorHandler implements XMLErrorHandler {
        @Override
        public void error(SAXException e) throws SAXException {
            System.out.println("SAXException: " + e.getMessage());
        }

        @Override
        public void fatalError(SAXException e) throws SAXException {
            System.out.println("Fatal SAXException: " + e.getMessage());
        }

        @Override
        public void warning(SAXWarning e) throws SAXException {
            System.out.println("SAXWarning: " + e.getMessage());
        }
    }

    private static class MyEntityResolver implements javax.xml.parsers.EntityResolver {
        @Override
        public Object getEntity(String url) throws SAXException {
            System.out.println("Entity resolution for " + url);
            return null;
        }
    }
}