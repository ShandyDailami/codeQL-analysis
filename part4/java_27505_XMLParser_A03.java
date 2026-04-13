import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_27505_XMLParser_A03 {
    public static void main(String[] args) {
        File xmlFile = new File("your_xml_file.xml");
        parseXml(xmlFile);
    }

    public static void parseXml(File xmlFile) {
        try {
            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
            MyHandler myHandler = new MyHandler();
            XMLReader reader = saxParser.getXMLReader();
            reader.setContentHandler(myHandler);
            reader.parse(xmlFile);
        } catch (SAXParseException e) {
            System.out.println("Parsing failed: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    private static class MyHandler extends DefaultHandler {
        private boolean isName = false;
        private boolean isAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if ("name".equals(localName)) {
                isName = true;
            } else if ("age".equals(localName)) {
                isAge = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ("name".equals(localName)) {
                isName = false;
            } else if ("age".equals(localName)) {
                isAge = false;
            }
        }

        @Override
        public void characters(char[] chars, int start, int length) throws SAXException {
            if (isName) {
                String name = new String(chars, start, length);
                System.out.println("Name: " + sanitize(name));
            } else if (isAge) {
                String age = new String(chars, start, length);
                System.out.println("Age: " + sanitize(age));
            }
        }

        private String sanitize(String input) {
            // sanitize input to prevent injection attacks
            // this is a simplistic example, not a complete solution
            return input.replace("<", "&lt;").replace(">", "&gt;");
        }
    }
}