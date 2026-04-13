import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLStreamException;

public class java_24145_XMLParser_A01 {

    private static final String XML_FILE = "src/test.xml"; // use your xml file

    public static void main(String[] args) {
        try {
            parseXmlFile(XML_FILE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parseXmlFile(String fileName) throws IOException, SAXException, XMLStreamException {
        File xmlFile = new File(fileName);
        XMLParser parser = xmlFile.isDirectory() ? XMLReader.class : XMLParser.class;
        DefaultHandler handler = new DefaultHandler() {
            boolean bName = false;
            boolean bValue = false;
            String value = null;

            @Override
            public void startDocument() throws SAXException {
                System.out.println("Start of document");
            }

            @Override
            public void endDocument() throws SAXException {
                System.out.println("End of document");
            }

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if (qName.equalsIgnoreCase("name")) {
                    bName = true;
                } else if (qName.equalsIgnoreCase("value")) {
                    bValue = true;
                }
            }

            @Override
            public java_24145_XMLParser_A01(String uri, String localName, String qName) throws SAXException {
                if (bName && bValue) {
                    System.out.println("Element Name: " + localName + ", Element Value: " + value);
                    bName = bValue = false;
                }
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                if (bName) {
                    value = new String(ch, start, length);
                }
            }
        };
        XMLParser xmlParser = (XMLParser) parser.newInstance();
        xmlParser.setContentHandler(handler);
        xmlParser.parse(new File(fileName));
    }
}