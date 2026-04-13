import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_18176_XMLParser_A07 {
    public static void main(String[] args) {
        File xmlFile = new File("resources/example.xml");
        XMLReader xmlReader = null;

        try {
            xmlReader = SAXParserFactory.newInstance().newSAXParser(new InputSource(new FileInputStream(xmlFile)));
            xmlReader.setContentHandler(new ContentHandlerImpl());
            xmlReader.parse(new InputSource(new FileInputStream(xmlFile)));
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        } finally {
            try {
                if (xmlReader != null) {
                    xmlReader.getParser().reset();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class ContentHandlerImpl extends DefaultHandler {
        @Override
        public void startDocument() {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            System.out.println("Start of element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End of element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            System.out.println("Characters: " + new String(ch, start, length));
        }

        @Override
        public void error(SAXException e) {
            System.err.println("SAXException: " + e);
        }

        @Override
        public void fatalError(SAXException e) {
            System.err.println("Fatal SAXException: " + e);
        }

        @Override
        public void warning(SAXException e) {
            System.err.println("Warning: " + e);
        }
    }
}