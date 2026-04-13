import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_03978_XMLParser_A01 {

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        parse(inputFile);
    }

    private static void parse(File inputFile) {
        XMLReader reader = null;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyContentHandler());
            reader.parse(inputFile.toURI().toString());
        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    static class MyContentHandler implements org.xml.sax.ContentHandler {

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}