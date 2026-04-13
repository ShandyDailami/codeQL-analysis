import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_29937_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create an XMLReader
            XMLReader reader = XMLReaderFactory.createXMLReader();

            // Create an InputStream from the XML file
            InputStream input = new FileInputStream("src/main/resources/sample.xml");

            // Create a SAXHandler to handle the XML
            SAXHandler handler = new SAXHandler();

            // Set the SAXHandler as the content handler
            reader.setContentHandler(handler);

            // Parse the XML
            reader.parse(input);

            // Close the InputStream
            input.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("SAXException: " + e.getMessage());
        }
    }
}