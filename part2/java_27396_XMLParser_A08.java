import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_27396_XMLParser_A08 {
    public static void main(String[] args) {
        String xmlFile = "path/to/your/xml/file.xml"; // replace with your actual xml file path
        parseXML(xmlFile);
    }

    private static void parseXML(String xmlFile) {
        DefaultHandler handler = new DefaultHandler() {
            boolean isName = false;
            boolean isValue = false;

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes)
                    throws SAXException {
                if (qName.equalsIgnoreCase("name")) {
                    isName = true;
                } else if (qName.equalsIgnoreCase("value")) {
                    isValue = true;
                }
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                if (qName.equalsIgnoreCase("name")) {
                    isName = false;
                } else if (qName.equalsIgnoreCase("value")) {
                    isValue = false;
                }
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                if (isName) {
                    // Handle 'name' event
                    System.out.println("Name: " + new String(ch, start, length));
                } else if (isValue) {
                    // Handle 'value' event
                    System.out.println("Value: " + new String(ch, start, length));
                }
            }
        };

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(new File(xmlFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}