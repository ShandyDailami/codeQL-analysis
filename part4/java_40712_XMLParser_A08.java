import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXParserFactory;
import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import java.io.File;
import java.io.IOException;

public class java_40712_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser(false);
            MyHandler handler = new MyHandler();
            XMLReader reader = parser.getXMLReader();
            reader.setContentHandler(handler);

            // Start reading from a file
            File xmlFile = new File("path_to_your_xml_file.xml");
            reader.parse(xmlFile);

        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        @Override
        public void startDocument() {
            System.out.println("Document started");
        }

        @Override
        public void endDocument() {
            System.out.println("Document ended");
        }

        @Override
        public void startElement(String uri, String localName, String qName) {
            System.out.println("Start of element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End of element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            String content = new String(ch, start, length);
            System.out.println("Characters: " + content);
        }

        @Override
        public void fatalError(SAXException e) {
            System.out.println("Fatal error: " + e.getMessage());
        }

        @Override
        public void warning(SAXException e) {
            System.out.println("Warning: " + e.getMessage());
        }
    }
}