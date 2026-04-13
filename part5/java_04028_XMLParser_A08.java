import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_04028_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFile = "src/main/resources/sample.xml"; // use your xml file here
        File xmlFileObj = new File(xmlFile);

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try (SAXParser saxParser = saxParserFactory.newSAXParser(new XMLReaderFactory().createXMLReader())) {
            saxParser.setContentHandler(new MyContentHandler());
            saxParser.parse(xmlFileObj);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyContentHandler implements org.xml.sax.ContentHandler {

        @Override
        public void startDocument() {
            // Use this for init code
        }

        @Override
        public void endDocument() {
            // Use this for end code
        }

        @Override
        public void startElement(String uri, String localName, String qualifiedName, org.xml.sax.Attributes attributes) {
            // Implement your security-sensitive operations here
        }

        @Override
        public void endElement(String uri, String localName, String qualifiedName) {
            // Implement your security-sensitive operations here
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            // Implement your security-sensitive operations here
        }

        @Override
        public void ignorableWhitespace(char[] ch, int start, int length) {
            // Implement your security-sensitive operations here
        }

        @Override
        public void systemInformation(String name, String value) {
            // Implement your security-sensitive operations here
        }
    }
}