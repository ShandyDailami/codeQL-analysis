import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLLoader;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class java_18537_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFilePath = "path_to_your_xml_file.xml";
        parseXML(xmlFilePath);
    }

    public static void parseXML(String xmlFilePath) {
        try {
            URL url = new File(xmlFilePath).toURI().toURL();
            XMLReader xmlReader = XMLParser.newSAXParser().getXMLReader(url);

            // Create a custom handler
            MyHandler myHandler = new MyHandler();
            xmlReader.setContentHandler(myHandler);

            // Parse XML file
            xmlReader.parse(new File(xmlFilePath));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    // Custom handler
    private static class MyHandler extends DefaultHandler {
        private boolean isName;
        private boolean isAge;
        private String name;
        private int age;

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Parsing start...");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("Parsing end...");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                isName = true;
                isAge = false;
            } else if (qName.equalsIgnoreCase("name")) {
                isName = true;
            } else if (qName.equalsIgnoreCase("age")) {
                isAge = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                isName = false;
                isAge = false;
            } else if (qName.equalsIgnoreCase("name")) {
                isName = false;
            } else if (qName.equalsIgnoreCase("age")) {
                isAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isName) {
                name = new String(ch, start, length);
            } else if (isAge) {
                age = Integer.parseInt(new String(ch, start, length));
            }
        }
    }
}