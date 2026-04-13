import java.io.FileInputStream;
import java.io.InputStream;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

public class java_24934_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a SAXHandler that will parse the XML file
            DefaultHandler handler = new DefaultHandler();
            SAXReader reader = new SAXReader();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader(handler);

            // Step 2: Open and parse the XML file
            InputStream inputStream = new FileInputStream("input.xml");
            reader.setContentHandler(handler);
            reader.setErrorHandler(handler);
            reader.parse(inputStream);

            // Step 3: If the parsing was successful, print a success message
            System.out.println("Parsing successful");
        } catch (Exception e) {
            // Step 4: Handle any errors during parsing
            e.printStackTrace();
        }
    }
}