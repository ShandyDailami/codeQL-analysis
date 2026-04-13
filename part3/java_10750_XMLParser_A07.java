import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;
import org.xml.sax.parser.XMLErrorHandler;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class java_10750_XMLParser_A07 {
    private static final String XML_FILE_PATH = "path_to_your_xml_file.xml"; // Replace with your actual XML file path

    public static void main(String[] args) {
        try {
            URL url = new File(XML_FILE_PATH).toURI().toURL();
            XMLLoader loader = new XMLLoader(url);
            loader.setErrorHandler(new MyErrorHandler());
            XMLParser parser = loader.getParser();

            parser.setContentHandler(new MyContentHandler());
            parser.parse(new File(XML_FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
            public void startElement(String uri, String localName, String qualifiedName, Attributes attributes) throws SAXException {
            System.out.println("Start of element: " + qualifiedName);
        }

        @Override
        public void endElement(String uri, String localName, String qualifiedName) throws SAXException {
            System.out.println("End of element: " + qualifiedName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String value = new String(ch, start, length).trim();
            if (!value.isEmpty()) {
                System.out.println("Character data: " + value);
            }
        }
    }

    private static class MyErrorHandler implements XMLErrorHandler {
        @Override
        public void fatalError(URL url, String errorMessage) {
            System.out.println("Fatal error: " + errorMessage);
        }

        @Override
        public void error(URL url, String errorMessage, int errorCode) {
            System.out.println("Error: " + errorMessage);
        }

        @Override
        public void warning(URL url, String warningMessage) {
            System.out.println("Warning: " + warningMessage);
        }

        @Override
        public void startDocument(String uri, String localName, String version) throws SAXException {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument(String uri, String localName, String version) throws SAXException {
            System.out.println("End of document");
        }
    }
}