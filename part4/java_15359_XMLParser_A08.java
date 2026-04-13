import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.Entity;
import org.xml.sax.entities.EntityResolver;
import org.xml.sax.helpers.DefaultEntityResolver;

import java.io.File;
import java.io.IOException;

public class java_15359_XMLParser_A08 {
    public static void main(String[] args) {
        // Create an entity resolver
        EntityResolver resolver = new DefaultEntityResolver();
        try {
            // Create an instance of XMLReader
            XMLReader reader = XMLReaderFactory.createXMLReader();

            // Set the entity resolver
            reader.setEntityResolver(resolver);

            // Parse the XML file
            reader.parse(new File("input.xml"));
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}