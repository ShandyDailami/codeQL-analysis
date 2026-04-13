import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_11243_XMLParser_A08 {

    public static void main(String[] args) {
        String filePath = "path_to_your_xml_file.xml";  // replace with your actual file path

        XMLReader xmlReader;
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            System.out.println("Failed to create XMLReader: " + e.getMessage());
            return;
        }

        SAXParserHandler saxParserHandler = new SAXParserHandler();

        try {
            xmlReader.setContentHandler(saxParserHandler);
            xmlReader.parse(new File(filePath));
        } catch (IOException e) {
            System.out.println("Failed to parse XML file: " + e.getMessage());
       
        } catch (SAXException e) {
            System.out.println("Error parsing XML file: " + e.getMessage());
        }
    }
}