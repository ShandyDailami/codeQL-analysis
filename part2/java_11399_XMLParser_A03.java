import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.handlers.DefaultHandler;
import org.xml.sax.helpers.XMLBeans;
import java.io.IOException;

public class java_11399_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new DefaultHandler());
            reader.setErrorHandler(new DefaultHandler());

            // Parse XML with custom validation
            reader.parse("src/main/resources/sample.xml");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}