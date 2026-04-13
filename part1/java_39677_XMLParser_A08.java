import java.io.File;
import java.io.IOException;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_39677_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("your_xml_file.xml"); // replace with your xml file

        XMLReader reader = null;
        try {
            reader = XMLReaderFactory.createXMLReader();

            // Create a new handler to process the XML document
            SAXHandler handler = new SAXHandler();
            reader.setContentHandler(handler);

            // Parse the XML document
            reader.parse(xmlFile);

            // Print the parsed data
            System.out.println("Parsed Data: " + handler.getParsedData());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } finally {
            // Cleanup
            if (reader != null) {
                reader.setContentHandler(null);
                reader.getDecoder().close();
            }
        }
    }
}