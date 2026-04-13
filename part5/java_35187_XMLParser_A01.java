import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicHandler;
import java.io.IOException;

public class java_35187_XMLParser_A01 {
    public static void main(String[] args) {
        BasicHandler handler = new BasicHandler();
        
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.setErrorHandler(handler);
            reader.getNamespaceSupport().registerNamespace("default", "http://www.example.com/misc");
            reader.parse("example.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}