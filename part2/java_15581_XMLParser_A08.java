import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLSAXParser;
import org.xml.sax.util.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_15581_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFile = "your_xml_file.xml";
        XMLHandler handler = new XMLHandler();
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(new File(xmlFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class XMLHandler extends DefaultHandler {

        boolean bTitle = false;
        boolean bLink = false;

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("title")) {
                bTitle = true;
            } else if (qName.equalsIgnoreCase("link")) {
                bLink = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (bTitle) {
                System.out.println("Title: " + qName);
                bTitle = false;
            } else if (bLink) {
                System.out.println("Link: " + qName);
                bLink = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bTitle) {
                System.out.print("Title: ");
                System.out.println(new String(ch, start, length));
                bTitle = false;
            } else if (bLink) {
                System.out.print("Link: ");
                System.out.println(new String(ch, start, length));
                bLink = false;
            }
        }
    }
}