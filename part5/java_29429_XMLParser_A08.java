import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_29429_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("input.xml");
        XMLReader xmlReader = null;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(new XMLElementHandler());
            xmlReader.parse(xmlFile);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        } finally {
            if (xmlReader != null) {
                xmlReader.close();
            }
        }
    }

    private static class XMLElementHandler implements org.xml.sax.helpers.DefaultHandler {
        private boolean bTag = false;
        private String currentElement = null;

        @Override
        public void startElement(String uri, String localName, String qName) throws SAXException {
            currentElement = qName;
            bTag = true;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            bTag = false;
            currentElement = null;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bTag) {
                System.out.println(currentElement + ": " + new String(ch, start, length));
            }
        }
    }
}