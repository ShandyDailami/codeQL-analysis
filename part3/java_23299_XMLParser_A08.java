import java.io.FileInputStream;
import java.io.InputStream;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_23299_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream("example.xml"); // Replace with your file path
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            
            SAXHandler saxHandler = new SAXHandler();
            xmlReader.setContentHandler(saxHandler);
            xmlReader.parse(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}