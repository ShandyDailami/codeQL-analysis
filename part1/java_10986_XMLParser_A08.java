import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXDriver;

import java.io.File;
import java.io.IOException;

public class java_10986_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("input.xml"); // input XML file

        SAXDriver driver = new SAXDriver();
        XMLReader reader = null;
        try {
            reader = XMLReaderFactory.createXMLReader();
            driver.setContentHandler(reader);
            reader.setFeature("http://xml.org/sax/features/namespaces", true);
            reader.setFeature("http://xml.org/sax/features/namespaces", false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            driver.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        }

        // Now you can process the parsed data in the ContentHandler
    }
}