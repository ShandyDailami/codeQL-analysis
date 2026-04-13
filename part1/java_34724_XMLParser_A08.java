import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXDriver;

public class java_34724_XMLParser_A08 {
    public static void main(String[] args) {
        SAXDriver driver = new SAXDriver();
        XMLReader reader = null;

        try {
            reader = XMLReaderFactory.createXMLReader();
            driver.setContentHandler(reader);

            // Start reading the XML document.
            reader.parse("src/main/resources/secure.xml");

            System.out.println("XML Document read successfully");
        } catch (SAXException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}