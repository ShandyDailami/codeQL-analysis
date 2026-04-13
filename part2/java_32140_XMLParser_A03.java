import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXParserFactory;
import org.xml.sax.XMLReader;

import java.io.File;
import java.io.IOException;

public class java_32140_XMLParser_A03 {
    public static void main(String[] args) {
        File xmlFile = new File("example.xml");

        // Step 1: Setup SAXParser.
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            XMLReader xmlReader = saxParserFactory.newSAXParser().getXMLReader();

            // Step 2: Create a SAXHandler and set it as the content handler for the XMLReader.
            xmlReader.setContentHandler(new MyHandler());

            // Step 3: Parse the XML file.
            xmlReader.parse(xmlFile);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            // No action required in this example.
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            // No action required in this example.
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            // No action required in this example.
        }
    }
}