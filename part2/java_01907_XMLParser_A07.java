import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicSaxDriver;

public class java_01907_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a SAX driver
            BasicSaxDriver driver = new BasicSaxDriver();

            // Create a new SAX reader
            XMLReader reader = XMLReaderFactory.createXMLReader();

            // Set the driver
            reader.setContentHandler(driver);

            // Parse the XML document
            reader.parse("example.xml");

            // Process the parsed data
            for (int i = 0; i < driver.getCount(); i++) {
                System.out.println(driver.getContent(i));
            }

        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}