import java.io.File;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_19216_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            SAXHandler handler = new SAXHandler();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}