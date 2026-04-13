import java.io.File;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_20230_XMLParser_A01 {
    public static void main(String[] args) {
        File xmlFile = new File("example.xml"); // replace with your xml file
        SAXParserHandler handler = new SAXParserHandler();

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}