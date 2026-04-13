import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_06870_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a new file reader
            File xmlFile = new File("example.xml");
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            // Create a new handler
            DefaultHandler defaultHandler = new DefaultHandler();

            // Set the handler for SAX
            xmlReader.setContentHandler(defaultHandler);

            // Parse the XML file
            xmlReader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}