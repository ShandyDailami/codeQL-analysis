import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_05292_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("input.xml");
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(new MyContentHandler());
            xmlReader.parse(xmlFile);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    static class MyContentHandler implements org.xml.sax.ContentHandler {

        @Override
        public void startDocument() throws SAXException {
            // Do nothing
        }

        @Override
        public void endDocument() throws SAXException {
            // Do nothing
        }

        @Override
        public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
            // Do nothing
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // Do nothing
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String content = new String(ch, start, length);
            // Here we assume that the content here is a potential SQL injection point
            // We could also use a regular expression or similar to check for SQL injection,
            // but for the sake of security, this example only checks for simple injection points
            if (content.contains("drop table")) {
                System.out.println("Potential SQL injection detected!");
            }
        }
    }
}