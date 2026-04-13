import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_31042_XMLParser_A01 {
    public static void main(String[] args) {
        String xmlFile = "path_to_your_xml_file";

        // Ensure the XML file is accessible
        try (InputStream input = new FileInputStream(xmlFile)) {
            parseXML(input);
        } catch (FileNotFoundException e) {
            System.out.println("Error: XML file not found.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void parseXML(InputStream input) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(false);
            MyHandler handler = new MyHandler();
            saxParser.parse(input, handler);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static class MyHandler extends DefaultHandler {
        private boolean isPerson;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            isPerson = localName.equals("person");
        }

        @Override
        public void characters(char[] chars, int start, int length) throws SAXException {
            if (isPerson) {
                String personName = new String(chars, start, length);
                System.out.println("Person: " + personName);
            }
        }
    }
}