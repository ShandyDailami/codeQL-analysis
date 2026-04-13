import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_36259_XMLParser_A03 {
    public static void main(String[] args) {
        String filename = "example.xml";
        File file = new File(filename);

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            SAXHandler handler = new SAAHandler();
            reader.setContentHandler(handler);
            reader.parse(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class SAAHandler extends DefaultHandler {
        boolean bElement = false;
        String thisElement = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            bElement = true;
            thisElement = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            bElement = false;
            if(thisElement.equalsIgnoreCase("element")) {
                System.out.println("Name: " + qName + ", Value: NONE");
            }
            thisElement = "";
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bElement) {
                System.out.println("Name: " + thisElement + ", Value: " + new String(ch, start, length));
            }
        }

        @Override
        public void startPrefixMapping(String prefix, String uri) throws SAXException {
            // not used in this example
        }

        @Override
        public void endPrefixMapping(String prefix) throws SAXException {
            // not used in this example
        }
    }
}