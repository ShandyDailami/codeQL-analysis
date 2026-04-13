import java.io.File;
import java.net.URI;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_32990_XMLParser_A03 {

    public static void parse(String file) throws SAXException {
        // Create a new file instance
        File xmlFile = new File(file);

        // Create a new URI instance
        URI uri = xmlFile.toURI();

        // Create a new XMLReader instance
        XMLReader xmlReader = XMLReaderFactory.createXMLReader();

        // Create a new SAXHandler instance
        SAXHandler saxHandler = new SAXHandler(uri);

        // Set the XMLReader's content handler
        xmlReader.setContentHandler(saxHandler);

        // Parse the XML file
        xmlReader.parse(new StringReader(xmlFile.toString()));
    }

    public static void main(String[] args) throws SAXException {
        parse("src/main/resources/sample.xml");
    }
}