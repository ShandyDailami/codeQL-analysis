import java.io.FileInputStream;
import java.io.IOException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_04592_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            FileInputStream input = new FileInputStream("sample.xml");
            SAXReader reader = new SAXReader();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            xmlReader.setContentHandler(new XmlHandler(reader));
            xmlReader.parse(input);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}