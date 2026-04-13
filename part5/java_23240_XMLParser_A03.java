import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_23240_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlFilePath = "path_to_your_xml_file.xml"; // replace with your xml file path
        File xmlFile = new File(xmlFilePath);

        XMLReader xmlReader;
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

        XmlHandler xmlHandler = new XmlHandler() {
            @Override
            public void startElement(String namespaceURI, String localName, String qualifiedName, org.xml.sax.Attributes atts) throws SAXException {
                System.out.println("Start element: " + localName);
            }

            @Override
            public void endElement(String namespaceURI, String localName, String qualifiedName) throws SAXException {
                System.out.println("End element: " + localName);
            }

            @Override
            public void characters(String namespaceURI, String localName, String qName, String value) throws SAXException {
                System.out.println("Character data: " + value);
            }
        };

        try {
            xmlReader.setContentHandler(xmlHandler);
            xmlReader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}