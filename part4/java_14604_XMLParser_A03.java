import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.DefaultHandler;

public class java_14604_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new DefaultHandler());
            reader.parse("src/main/resources/example.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}