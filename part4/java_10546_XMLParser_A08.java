import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_10546_XMLParser_A08 {

    public static void parse(String filename) {
        try {
            File inputFile = new File(filename);
            XMLReader parser = XMLReaderFactory.createXMLReader();

            parser.setFeature("http://xml.org/sax/features/namespaces", true);
            parser.setFeature("http://xml.org/sax/features/namespaces", false);

            parser.setFeature("http://xml.org/sax/features/namespace-prefixes", true);

            parser.setFeature("http://xml.org/sax/features/validation", true);
            parser.setFeature("http://xml.org/sax/features/validation", false);

            parser.setFeature("http://xml.org/sax/features/external-general-entities", false);
            parser.setFeature("http://xml.org/sax/features/external-parameters", false);
            parser.setFeature("http://xml.org/sax/features/rng-mode", false);

            SecurityAwareHandler handler = new SecurityAwareHandler();
            parser.setContentHandler(handler);

            parser.parse(inputFile);

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        parse("example.xml");
    }
}