import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entries.BasicHandler;

import java.io.File;
import java.io.IOException;

public class java_09326_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file.xml");

        XMLReader reader = null;
        try {
            reader = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        BasicHandler handler = new BasicHandler() {
            public void startElement(String uri, String localName, String qName,
                                     org.xml.sax.Attributes attributes) throws SAXException {
                System.out.println("Start Element: " + qName);
                for (int i = 0; i < attributes.getLength(); i++) {
                    System.out.println("Attribute: " + attributes.getQName(i) + " = " + attributes.getValue(i));
                }
            }

            public void endElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("End Element: " + qName);
            }

            public void characters(char[] ch, int start, int length) throws SAXException {
                System.out.println("Characters: " + new String(ch, start, length));
            }
        };

        try {
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}