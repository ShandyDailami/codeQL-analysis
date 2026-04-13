import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_18979_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("your_xml_file.xml"); // replace with your xml file
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(new DefaultHandler() {
                @Override
                public void startElement(String uri, String localName, String qName,
                        org.xml.sax.Attributes attributes) throws SAXException {
                    System.out.println("Start Element: " + qName);
                    for (int i = 0; i < attributes.getLength(); i++) {
                        System.out.println("Attribute: " + attributes.getQName(i) + " = " + attributes.getValue(i));
                    }
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("End Element: " + qName);
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    System.out.println("Characters: " + new String(ch, start, length));
                }
            });
            xmlReader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}