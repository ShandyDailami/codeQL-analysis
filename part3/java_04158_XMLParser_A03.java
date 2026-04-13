import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXEntry;

public class java_04158_XMLParser_A03 {
    public static void main(String[] args) {
        SAXEntry saxEntry = new SAXEntry();

        XMLReader xmlReader = null;
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(saxEntry);
            xmlReader.parse("resources/yourFile.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}