import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_17852_XMLParser_A01 {

    public static void main(String[] args) {

        String xmlFile = "path/to/your/file.xml";  // replace with your xml file path

        File xmlFileObj = new File(xmlFile);
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();

            // Create a new handler
            XMLReaderHandler handler = new XMLReaderHandler();
            reader.setContentHandler(handler);

            // Parse the XML file
            reader.parse(xmlFileObj.toURI().toString());

            // Print the parsed information
            System.out.println("Parsed XML File Successfully");
            System.out.println("Parsed XML Data: " + handler.getParsedData());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}