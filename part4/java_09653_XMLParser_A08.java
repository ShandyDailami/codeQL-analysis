import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXDriver;

public class java_09653_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            SAXDriver driver = new SAXDriver();
            XMLReader reader = XMLReaderFactory.createXMLReader();

            // Create a new XMLHandler and pass the reader to it
            MyHandler handler = new MyHandler();
            reader.setContentHandler(handler);

            // Parse the XML file
            driver.parse("src/main/resources/test.xml");

        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}