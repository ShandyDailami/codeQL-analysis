import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

public class java_26564_XMLParser_A03 {

    private static final String XML_FILE_PATH = "your_xml_file_path"; // change this to your xml file path

    public static void main(String[] args) {
        // Create a SAXParser
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(new org.xml.sax.InputSource(getFileAsInputStream(XML_FILE_PATH)));

        // Create a DefaultHandler
        MyHandler myHandler = new MyHandler();

        // Parse the XML file
        try {
            saxParser.parse(new org.xml.sax.InputSource(getFileAsInputStream(XML_FILE_PATH)), myHandler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        // Print the parsed data
        System.out.println(myHandler.getData());
    }

    // Method to read a file as an InputStream
    private static InputStream getFileAsInputStream(String filePath) {
        try {
            URL url = new File(filePath).toURI().toURL().openStream();
            return url.openStream();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // MyHandler is a DefaultHandler that stores parsed data
    private static class MyHandler extends DefaultHandler {
        private String data;

        public void startDocument() {
            data = "";
        }

        public void endDocument() {
            // no-op
        }

        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            // no-op
        }

        public void endElement(String uri, String localName, String qName) {
            // no-op
        }

        public void characters(char[] ch, int start, int length) {
            data += new String(ch, start, length);
        }

        public String getData() {
            return data;
        }
    }
}