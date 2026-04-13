import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXHandler;

public class java_03370_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            SAXHandler handler = new SAXHandler();
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse("src/main/resources/input.xml"); // replace with your xml file path
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}