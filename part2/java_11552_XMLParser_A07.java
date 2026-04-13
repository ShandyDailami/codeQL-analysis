import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class java_11552_XMLParser_A07 {

    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file");
        parseXML(xmlFile);
    }

    private static void parseXML(File xmlFile) {
        try {
            InputStream inputStream = new FileInputStream(xmlFile);
            SAXParserHandler handler = new SAXParserHandler();
            XMLParser parser = new SAXParser(handler);
            parser.parse(inputStream);
            inputStream.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static class SAXParserHandler extends DefaultHandler {

        private boolean nameFound = false;
        private boolean contentFound = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("name")) {
                nameFound = true;
            } else if (qName.equalsIgnoreCase("content")) {
                contentFound = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (nameFound && contentFound) {
                System.out.println("Name: " + new String(ch, start, length));
                System.out.println("Content: " + new String(ch, start, length));
                nameFound = false;
                contentFound = false;
            }
        }
    }
}