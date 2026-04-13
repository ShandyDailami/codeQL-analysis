import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_32551_XMLParser_A01 {

    public static void main(String[] args) {
        String xmlFile = "src/main/resources/data.xml";

        try {
            File xmlFilePath = new File(xmlFile);
            XMLReader reader = XMLReaderFactory.createXMLReader();

            reader.setContentHandler(new XMLEventHandler());

            reader.parse(xmlFilePath);

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class XMLEventHandler implements org.xml.sax.helpers.DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes)
                throws SAXException {
            System.out.println("Element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String strChars = new String(ch, start, length);
            System.out.println("Text: " + strChars);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End of Element: " + qName);
        }

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of Document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of Document");
        }
    }
}