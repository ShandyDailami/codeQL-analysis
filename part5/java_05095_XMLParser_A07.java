import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.SAXEntityResolver;
import java.io.File;
import java.io.IOException;

public class java_05095_XMLParser_A07 {
    public static void main(String[] args) {
        File xmlFile = new File("sample.xml"); // replace with your XML file path

        SAXEntityResolver resolver = new SAXEntityResolver() {
            public java.io.InputStream resolveEntity(String publicId, String systemId) throws SAXException, IOException {
                // handle security-sensitive operations here
                // return null if the entity is not found
                return null;
            }
        };

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader(resolver);
            XMLReaderHandler handler = new XMLReaderHandler();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}