import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_25521_XMLParser_A01 {

    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file");
        parseXml(xmlFile);
    }

    public static void parseXml(File xmlFile) {
        DefaultHandler handler = new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                System.out.println("Start element: " + qName);
            }

            @Override
            public void endElement(String uri, String localName, String qName) {
                System.out.println("End element: " + qName);
            }

            @Override
            public void characters(char[] ch, int start, int length) {
                String value = new String(ch, start, length);
                System.out.println("Character data: " + value);
            }
        };

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(xmlFile.getAbsolutePath());
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}