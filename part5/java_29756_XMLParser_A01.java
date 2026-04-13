import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicHandler;

import java.io.File;
import java.io.IOException;

public class java_29756_XMLParser_A01 {

    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_file.xml");
        parseFile(xmlFile);
    }

    public static void parseFile(File file) {
        BasicHandler handler = new BasicHandler() {
            @Override
            public void endDocument() {
                System.out.println("End of document");
            }

            @Override
            public void startDocument() throws SAXException {
                System.out.println("Start of document");
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("End element: " + localName);
            }

            @Override
            public void startElement(String uri, String localName, String qName, String... attributes) throws SAXException {
                System.out.println("Start element: " + localName);
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                System.out.println("Characters: " + new String(ch, start, length));
            }
        };

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(file.toURI().toString());
        } catch (IOException e) {
            System.out.println("Failed to parse XML file: " + e.getMessage());
        }
    }
}