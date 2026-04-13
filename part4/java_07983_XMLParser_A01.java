import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_07983_XMLParser_A01 {

    public static void main(String[] args) {
        String xmlFilePath = "path_to_your_xml_file.xml";  // replace with your xml file path
        parseXMLFile(xmlFilePath);
    }

    private static void parseXMLFile(String xmlFilePath) {
        File xmlFile = new File(xmlFilePath);

        if (!xmlFile.exists()) {
            System.out.println("XML file not found!");
            return;
        }

        XMLReader xmlReader;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setEntityResolver(new MyEntityResolver());
        } catch (SAXException e) {
            System.out.println("Error creating SAX reader: " + e.getMessage());
            return;
        }

        xmlReader.setContentHandler(new MyContentHandler(xmlFilePath));

        try {
            xmlReader.parse(xmlFile);
        } catch (IOException e) {
            System.out.println("Error parsing XML file: " + e.getMessage());
        }
    }
}