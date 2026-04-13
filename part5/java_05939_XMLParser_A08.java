import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_05939_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            parseFile("sample.xml");
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void parseFile(String fileName) throws ParserConfigurationException, SAXException, IOException {
        // Create a new XMLReader object
        XMLReader reader = XMLReaderFactory.createXMLReader();

        // Create a new SAXHandler object
        MySAXHandler handler = new MySAXHandler();

        // Set the handler for the XMLReader
        reader.setContentHandler(handler);

        // Parse the XML file
        reader.parse(new File(fileName));

        // Print the integrity failures found
        for (String failure : handler.getFailures()) {
            System.out.println("Integrity failure detected: " + failure);
        }
    }
}