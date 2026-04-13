import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLErrorHandler;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class java_25999_XMLParser_A08 {

    private static class MyHandler extends DefaultHandler {

        private boolean tagFound;
        private StringBuilder data;

        public java_25999_XMLParser_A08() {
            this.data = new StringBuilder();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            tagFound = true;
            data.setLength(0);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (!tagFound) {
                System.out.println("Security warning: Tag " + qName + " was not found in the XML document");
            }
            tagFound = false;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (tagFound) {
                data.append(ch, start, length);
            }
        }

        public String getData() {
            return data.toString();
        }
    }

    public static void parseXML(String filePath) throws IOException, SAXException {
        MyHandler handler = new MyHandler();

        URL url = new File(filePath).toURI().toURL();
        XMLParser parser = XMLReader.newInstance().withErrorHandler(new XMLErrorHandler() {
            @Override
            public void warning(SAXParseException e) throws SAIXMLReadException {
                System.out.println("Warning: " + e.getMessage());
            }

            @Override
            public void error(SAXParseException e) throws SAIXMLReadException {
                System.out.println("Error: " + e.getMessage());
            }

            @Override
            public void fatalError(SAXParseException e) throws SAIXMLReadException {
                System.out.println("Fatal Error: " + e.getMessage());
            }
        });

        XMLLoader loader = XMLLoader.builder(url).build();
        loader.setContentHandler(handler);
        loader.parse();
    }

    public static void main(String[] args) throws IOException, SAXException {
        parseXML("https://raw.githubusercontent.com/dumblob/sample/master/sample.xml");
    }
}