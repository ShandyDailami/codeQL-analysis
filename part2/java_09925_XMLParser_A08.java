import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_09925_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFilePath = "path_to_your_xml_file.xml";
        parseXMLFile(xmlFilePath);
    }

    private static void parseXMLFile(String xmlFilePath) {
        File xmlFile = new File(xmlFilePath);

        try {
            SAXReader saxReader = SAXReaderFactory.newInstance();
            XMLReader xmlReader = saxReader.getXMLReader();
            xmlReader.setContentHandler(new MyContentHandler());
            xmlReader.parse(xmlFile);
        } catch (SAXParseException e) {
            System.out.println("Parsing failed: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error while reading the XML file: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Error in the XML schema: " + e.getMessage());
        }
    }

    private static class MyContentHandler extends DefaultHandler {
        private static final String TAG_NAME = "tag_name";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("Start element: " + qName);

            if (attributes.getLength() > 0) {
                System.out.println("Attributes: ");
                for (int i = 0; i < attributes.getLength(); i++) {
                    System.out.println("Attribute Name: " + attributes.getQName(i) + ", Value: " + attributes.getValue(i));
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Character data: " + new String(ch, start, length));
        }
    }
}