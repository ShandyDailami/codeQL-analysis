import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_17980_XMLParser_A07 {
    public static void main(String[] args) {
        File xmlFile = new File("src/main/resources/sample.xml");
        parseXML(xmlFile);
    }

    private static void parseXML(File xmlFile) {
        XMLReader reader;
        DefaultHandler handler = new DefaultHandler() {
            public void startDocument() {
                System.out.println("Start of document");
            }

            public void endDocument() {
                System.out.println("End of document");
            }

            public void startElement(String uri, String localName, String qName) {
                System.out.println("Start of element: " + qName);
            }

            public void endElement(String uri, String localName, String qName) {
                System.out.println("End of element: " + qName);
            }

            public void characters(char[] ch, int start, int length) {
                System.out.println("Reading characters: " + new String(ch, start, length));
            }
        };

        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}