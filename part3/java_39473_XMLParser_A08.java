import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.XMLReader;
import java.io.File;
import java.io.IOException;

public class java_39473_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setFeature("http://xml.org/sax/features/namespaces", true);
            xmlReader.setFeature("http://xml.org/sax/features/external-general-entity-refs", false);
            xmlReader.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            xmlReader.setFeature("http://xml.org/sax/features/rng-supported", true);
            xmlReader.setFeature("http://xml.org/sax/features/database-support", false);
            xmlReader.setFeature("http://xml.org/sax/features/valid-language", false);
            xmlReader.setFeature("http://xml.org/sax/features/xinclude", false);
            xmlReader.setFeature("http://xml.org/sax/features/namespace-prefix-mapping", false);
            xmlReader.setFeature("http://xml.org/sax/features/xml-version", true);
            xmlReader.setFeature("http://xml.org/sax/features/validation", true);
            xmlReader.setFeature("http://xml.org/sax/features/external-dtd", false);

            xmlReader.setContentHandler(new ContentHandler());
            xmlReader.parse(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}