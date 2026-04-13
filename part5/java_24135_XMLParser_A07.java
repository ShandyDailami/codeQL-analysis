import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_24135_XMLParser_A07 {

    public void parseFile(String fileName) {
        File file = new File(fileName);

        // Create SAX reader
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

        // Create event handler
        XmlHandler handler = new XmlHandler();
        reader.setContentHandler(handler);

        // Parse file
        try {
            reader.parse(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            System.out.println("Error parsing XML: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        XmlParser parser = new XmlParser();
        parser.parseFile("path_to_your_xml_file");
    }
}