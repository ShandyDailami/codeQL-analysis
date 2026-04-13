import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_16207_XMLParser_A03 {
    public static void main(String[] args) {
        File xmlFile = new File("your_xml_file.xml");

        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            System.out.println("Error creating XMLReader: " + e.getMessage());
            return;
        }

        XMLReaderHandler handler = new XMLReaderHandler();
        reader.setContentHandler(handler);

        try {
            reader.parse(xmlFile);
        } catch (IOException e) {
            System.out.println("Error reading XML file: " + e.getMessage());
            return;
        } catch (SAXException e) {
            System.out.println("Error processing XML: " + e.getMessage());
            return;
        }

        System.out.println("XML parsed successfully.");
    }
}