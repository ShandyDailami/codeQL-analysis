import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_35423_XMLParser_A07 {
    public static void main(String[] args) {
        String xmlFilePath = "your_xml_file_path.xml"; // replace with your xml file path
        parseXml(xmlFilePath);
    }

    public static void parseXml(String xmlFilePath) {
        DefaultHandler handler = new DefaultHandler() {
            boolean isName = false;
            String name = null;

            @Override
            public void startElement(String uri, String localName, String qName, java.util.Properties properties)
                    throws SAXException {
                if (qName.equals("name")) {
                    isName = true;
                }
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                if (isName) {
                    name = new String(ch, start, length);
                    isName = false;
                }
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                if (qName.equals("name")) {
                    System.out.println("Name: " + name);
                }
            }
        };

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(new File(xmlFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}