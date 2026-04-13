import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXReader;

public class java_24578_XMLParser_A08 {

    private static final String FILE_PATH = "src/main/resources/data.xml";

    public static void main(String[] args) {
        File file = new File(FILE_PATH);

        try (SAXParserFactory factory = SAXParserFactory.newInstance();
             SAXParser parser = factory.newSAXParser(file.toURI().toURL())) {

            Handler handler = new Handler();
            parser.setContentHandler(handler);

            XMLReader reader = SAXReader.newInstance().getReader(file);
            parser.parse(reader, handler);

        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

    static class Handler extends DefaultHandler {

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
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            System.out.println("Character data: " + new String(ch, start, length));
        }

        @Override
        public void ignorableWhitespace(char[] ch, int start, int length) {
            System.out.println("Ignorable whitespace: " + new String(ch, start, length));
        }

        @Override
        public void warning(SAXParseException e) {
            System.out.println("Warning: " + e.getMessage());
        }

        @Override
        public void error(SAXParseException e) {
            System.out.println("Error: " + e.getMessage());
        }

        @Override
        public void fatalError(SAXParseException e) {
            System.out.println("Fatal error: " + e.getMessage());
        }
    }
}