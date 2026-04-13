import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXDriver;

public class java_29991_XMLParser_A03 {
    public static void main(String[] args) {
        SAXDriver driver = new SAXDriver();
        XMLReader reader = null;

        try {
            reader = XMLReaderFactory.createXMLReader();
            driver.setContentHandler(reader);
            driver.setErrorHandler(reader);

            // Parse the XML file
            reader.parse("src/example.xml");

            // Extract information from the XML file
            System.out.println("Tag Name: " + reader.getCurrentToken().getLocalName());
            System.out.println("Tag Value: " + reader.getCurrentToken().getCharacterData().getData());

        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}