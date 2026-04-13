import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_05685_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("example.xml");
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setFeature("http://xml.org/sax/features/namespaces", true);
            reader.setFeature("http://xml.org/sax/features/namespace-prefixes", true);
            reader.setFeature("http://xml.org/sax/features/validation", true);
            reader.setFeature("http://xml.org/sax/features/xinclude", true);
            reader.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd", false);
            reader.setFeature("http://xml.org/sax/features/external-parameter", false);
            reader.setFeature("http://xml.org/sax/features/rng-support", false);
            reader.setFeature("http://xml.org/sax/features/xml-version", false);
            reader.setFeature("http://xml.org/sax/features/error-handler", true);
            reader.setFeature("http://xml.org/sax/features/lexical-handler", false);

            XMLHandler handler = new XMLHandler();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}