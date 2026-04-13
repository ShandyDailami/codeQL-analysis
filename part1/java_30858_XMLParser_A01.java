import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_30858_XMLParser_A01 {

    public static void main(String[] args) throws IOException, SAXException {

        // Create a new XMLReader instance
        XMLReader reader = XMLReaderFactory.createXMLReader();

        // Create a new XMLParser instance
        XMLParserHandler handler = new XMLParserHandler();

        // Set the parser handler
        reader.setContentHandler(handler);

        // Parse the XML file
        reader.parse(new File("src/main/resources/example.xml"));
    }
}