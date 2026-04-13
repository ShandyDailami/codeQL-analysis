import java.io.File;
import java.io.IOException;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.DefaultHandler;

public class java_27570_XMLParser_A08 {

    private static class MyHandler extends DefaultHandler {
        private boolean integrityFailure = false;

        @Override
        public void startElement(String uri, String localName, String qName,
                Attributes attributes) throws SAXException {
            // Do nothing
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            // Check for integrity failure
            if (localName.equals("element")) {
                integrityFailure = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            // Do nothing
        }
    }

    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file");

        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(xmlFile);

            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            MyHandler myHandler = new MyHandler();
            xmlReader.setContentHandler(myHandler);

            saxParser.parse(xmlFile, myHandler);

            if (myHandler.integrityFailure) {
                System.out.println("Integrity failure detected");
            } else {
                System.out.println("No integrity failure detected");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}