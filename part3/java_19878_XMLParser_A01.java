import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_19878_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(true);

        // Create a handler to process the SAX events
        DefaultHandler defaultHandler = new DefaultHandler() {
            boolean isAccessControlElement = false;
            String currentElement = "";

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if ("accessControl".equals(qName)) {
                    isAccessControlElement = true;
                    currentElement = qName;
                }
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                if (isAccessControlElement && "accessControl".equals(qName)) {
                    System.out.println("Access control element found!");
                    isAccessControlElement = false;
                }
                currentElement = "";
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                if (isAccessControlElement) {
                    String data = new String(ch, start, length);
                    System.out.println("Data inside access control element: " + data);
                }
                currentElement = "";
            }
        };

        // Parse the XML file
        saxParser.parse(new File("src/main/resources/broken_access_control.xml"), defaultHandler);
    }
}