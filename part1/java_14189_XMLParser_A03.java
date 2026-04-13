import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entries.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_14189_XMLParser_A03 {

    public static void main(String[] args) {
        File xmlFile = new File("example.xml");
        DefaultHandler handler = new DefaultHandler();

        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader(handler);
            reader.setFeature("http://xml.org/sax/features/namespaces", true);
            reader.setFeature("http://xml.org/sax/features/namespace-prefixes", true);

            reader.setFeature("http://xml.org/sax/features/external-general-entities", false);
            reader.setFeature("http://xml.org/sax/features/external-parameter-entities", false);

            reader.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}