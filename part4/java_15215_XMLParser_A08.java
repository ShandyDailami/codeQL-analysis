import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_15215_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("example.xml");  // replace with your xml file

        // Check if the xml file exists
        if (!xmlFile.exists()) {
            System.out.println("File not found!");
            return;
        }

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();

            // Create an instance of the Handler
            XmlHandler handler = new XmlHandler();

            // Set the Handler for the Reader
            reader.setContentHandler(handler);

            // Parse the XML
            reader.parse(Files.newInputStream(xmlFile.toPath()));

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}