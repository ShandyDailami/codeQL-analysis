import java.io.FileInputStream;
import java.io.InputStream;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_37972_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            String fileName = "example.xml";
            parseXMLFile(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseXMLFile(String fileName) {
        InputStream inputStream = null;
        XMLReader reader = null;

        try {
            inputStream = new FileInputStream(fileName);
            reader = XMLReaderFactory.createXMLReader();

            MyHandler handler = new MyHandler();
            reader.setContentHandler(handler);

            reader.parse(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static class MyHandler extends DefaultHandler {
        private boolean nameFound = false;
        private boolean ageFound = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                nameFound = true;
                ageFound = false;
            } else if (nameFound && qName.equalsIgnoreCase("name")) {
                System.out.println("Name: " + attributes.getValue("name"));
                nameFound = false;
            } else if (nameFound && qName.equalsIgnoreCase("age")) {
                System.out.println("Age: " + attributes.getValue("age"));
                ageFound = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                nameFound = false;
                ageFound = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (nameFound && ageFound) {
                System.out.println("Name: " + new String(ch, start, length));
            }
        }
    }
}