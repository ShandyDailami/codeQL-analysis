import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicEntityResolver;
import org.xml.sax.sax2.SAX2XMLReader;

import java.io.File;

public class java_31156_XMLParser_A03 {
    public static void main(String[] args) {
        // Create a file instance for the XML file
        File xmlFile = new File("sample.xml");
        
        // Create an entity resolver
        BasicEntityResolver entityResolver = new BasicEntityResolver();
        
        // Create a SAX2 XML reader
        SAX2XMLReader reader = (SAX2XMLReader) XMLReaderFactory.createXMLReader();
        
        // Set the entity resolver
        reader.setEntityResolver(entityResolver);
        
        // Create a SAX handler
        XMLParserHandler handler = new XMLParserHandler();
        
        // Parse the XML file
        try {
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}