import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXDriver;

public class java_34060_XMLParser_A03 {
    public static void main(String[] args) {
        SAXDriver driver = new SAXDriver();
        XMLReader reader = null;

        try {
            reader = XMLReaderFactory.createXMLReader();
            SAXHandler handler = new SAXHandler();
            reader.setContentHandler(handler);

            // Parse XML with SAX
            driver.parse("sample.xml", handler);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}