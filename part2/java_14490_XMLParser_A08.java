import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_14490_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml"); // specify your xml file path
            FileInputStream fis = new FileInputStream(xmlFile);
            SAXReader saxReader = new SAXReader();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            xmlReader.setContentHandler(new MyContentHandler());
            xmlReader.parse(fis);

            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}