import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_00364_XMLParser_A03 {

    public static void main(String[] args) throws ParserConfigurationException, SAXException {

        // Create the XMLReader
        XMLReader reader = XMLReaderFactory.createXMLReader();

        // Create a custom handler
        SAXHandler handler = new SAXHandler();
        reader.setContentHandler(handler);

        // Parse the XML
        reader.parse("example.xml");
    }

    static class SAXHandler extends DefaultHandler {

        boolean bElement = false;
        String strData = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            bElement = true;
            strData = "";
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bElement) {
                strData = new String(ch, start, length);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            bElement = false;
            // Here you can add the logic to process the XML data
            System.out.println("Element: " + qName + ", Data: " + strData);
        }
    }
}