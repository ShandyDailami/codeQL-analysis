import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_00233_XMLParser_A01 {
    public static void main(String[] args) {
        File xmlFile = new File("example.xml");  // replace with your XML file path

        XMLReader reader = null;
        try {
            reader = XMLReaderFactory.createXMLReader();

            // Create a custom XML content handler
            SAXHandler contentHandler = new SAAXContentHandler(reader);

            // Set the content handler for the reader
            reader.setContentHandler(contentHandler);

            // Parse the XML file
            reader.parse(xmlFile);

            // Print out the names of all the elements in the XML document
            contentHandler.printElements();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}