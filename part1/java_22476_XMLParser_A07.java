import java.io.FileInputStream;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXDriver;

public class java_22476_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("sample.xml");
            SAXDriver driver = new SAXDriver(new MyHandler());
            XMLReader reader = XMLReaderFactory.createXMLReader();

            reader.setContentHandler(driver);
            reader.setErrorHandler(driver);

            reader.parse(fis);

            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}