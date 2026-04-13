import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXHandler;

public class java_30065_XMLParser_A01 {

    public static void main(String[] args) {
        SAXHandler saxHandler = new SAXHandler();
        XMLReader xmlReader = null;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(saxHandler);
            xmlReader.parse("src/main/resources/example.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}