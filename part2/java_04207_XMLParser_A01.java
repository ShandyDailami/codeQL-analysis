import java.io.FileInputStream;
import java.io.InputStream;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_04207_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create SAX parser
            XMLReader reader = XMLReaderFactory.createXMLReader();

            // Create an InputStream from a file
            InputStream input = new FileInputStream("input.xml");

            // Parse the XML file
            reader.setContentHandler(new MyContentHandler());
            reader.parse(input);

            // Close the input stream
            input.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}