import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_20092_XMLParser_A07 {
    public static void main(String[] args) {
        File xmlFile = new File("example.xml");
        XMLReader xmlReader = null;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setFeature("http://xml.org/sax/features/namespaces", true);
            xmlReader.setFeature("http://xml.org/sax/features/namespace-prefixes", true);
            xmlReader.setFeature("http://xml.org/sax/features/validation", false);
            xmlReader.setFeature("http://xml.org/sax/features/external-general-entities", false);
            xmlReader.setFeature("http://xml.org/sax/features/external-parameters", false);
            xmlReader.setFeature("http://xml.org/sax/features/rng-supported", false);
            xmlReader.setFeature("http://xml.org/sax/features/xml-version", false);
            xmlReader.setFeature("http://xml.org/sax/features/error-handler", true);

            xmlReader.setContentHandler(new SAXContentHandler(xmlReader));
            xmlReader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}