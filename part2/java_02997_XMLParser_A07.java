import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicHandler;
import java.io.File;
import java.io.IOException;

public class java_02997_XMLParser_A07 {
    public static void main(String[] args) {
        File xmlFile = new File("path/to/your/xml/file.xml");
        BasicHandler handler = new BasicHandler();
        XMLReader reader = null;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}