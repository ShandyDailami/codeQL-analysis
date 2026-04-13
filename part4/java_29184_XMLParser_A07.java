import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXDriver;

public class java_29184_XMLParser_A07 {
    public static void main(String[] args) {
        SAXDriver driver = new SAXDriver();
        XMLReader reader = null;

        try {
            reader = XMLReaderFactory.createXMLReader();
            SAXHandler handler = new SAXHandler();
            driver.setContentHandler(handler);
            driver.parse("data.xml"); // replace with your file
        } catch (SAXException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}