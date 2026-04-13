import java.io.FileInputStream;
import java.io.InputStream;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_14051_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream("example.xml");
            XMLReader reader = XMLReaderFactory.createXMLReader();

            // Create a custom SAXHandler
            SAXHandler saxHandler = new SAXHandler();
            reader.setContentHandler(saxHandler);

            // Parse the XML file
            reader.parse(inputStream);

            // Print the results
            System.out.println("Found " + saxHandler.getCount() + " elements.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}