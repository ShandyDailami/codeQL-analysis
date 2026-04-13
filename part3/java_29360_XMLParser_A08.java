import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_29360_XMLParser_A08 {

    private static final String XML_FILE_PATH = "src/main/resources/sample.xml";

    public static void main(String[] args) {
        try {
            File xmlFile = new File(XML_FILE_PATH);
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setFeature("http://xml.org/sax/features/namespaces", true);
            reader.setFeature("http://xml.org/sax/features/namespace-prefixes", true);
            reader.setFeature("http://xml.org/sax/features/rfc-1321-basics", false);
            reader.setFeature("http://xml.org/sax/features/validation", false);
            reader.setFeature("http://xml.org/sax/features/external-general-entities", false);
            reader.setFeature("http://xml.org/sax/features/external-parameters", false);
            reader.setFeature("http://xml.org/sax/features/rfc-1321-parse", true);

            SAXHandler handler = new SAXHandler();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);

            System.out.println("Parsing succeeded");
        } catch (IOException e) {
            System.out.println("Error reading the XML file: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Error parsing the XML file: " + e.getMessage());
        }
    }
}