import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entries.DefaultHandler;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_29742_XMLParser_A08 {
    public static void main(String[] args) {
        String xmlFilePath = "your_xml_file_path.xml"; // replace with your XML file path
        parseXml(xmlFilePath);
    }

    private static void parseXml(String xmlFilePath) {
        File xmlFile = new File(xmlFilePath);
        XMLReader reader;
        DefaultHandler handler = new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                System.out.println("Element: " + qName);
            }

            @Override
            public void characters(char[] ch, int start, int length) {
                String content = new String(ch, start, length);
                System.out.println("Content: " + content);
            }
        };

        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}