import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_03634_XMLParser_A07 {
    public static void main(String[] args) {
        String xmlFilePath = "path_to_your_xml_file.xml";

        // Create a SAX parser
        SAXReader reader = new SAXReader();

        // Create a handler to process the content of each element
        DefaultHandler handler = new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes)
                    throws SAXException {
                System.out.println("Start Element: " + qName);
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("End Element: " + qName);
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                System.out.println("Characters: " + new String(ch, start, length));
            }
        };

        // Create a SAX reader
        XMLReader xmlReader;
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(handler);

            // Parse the XML file
            xmlReader.parse(new File(xmlFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXParseException e) {
            System.out.println("Parse Error: " + e.getMessage());
        }
    }
}