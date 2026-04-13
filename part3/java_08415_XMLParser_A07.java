import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_08415_XMLParser_A07 {

    public static void main(String[] args) {
        String xmlFile = "sample.xml"; // File path of your XML file
        parseXML(xmlFile);
    }

    private static void parseXML(String xmlFile) {
        File xml = new File(xmlFile);
        XMLReader reader;

        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setFeature("http://xml.org/sax/features/namespaces", true);
            reader.setFeature("http://xml.org/sax/features/namespace-prefixes", true);

            // SAX parsing
            reader.setContentHandler(new XMLContentHandler());
            reader.parse(xml.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}