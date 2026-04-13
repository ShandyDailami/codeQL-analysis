import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_39464_XMLParser_A01 {

    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file.xml");
        parseXMLFile(xmlFile);
    }

    private static void parseXMLFile(File xmlFile) {
        DefaultHandler handler = new DefaultHandler() {
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                System.out.println("Start element: " + qName);
            }

            public void endElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("End element: " + qName);
            }
        };

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.setErrorHandler(handler);
            reader.parse(xmlFile.toURI().toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}