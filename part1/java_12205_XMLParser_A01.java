import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_12205_XMLParser_A01 {
    public static void main(String[] args) {
        File xmlFile = new File("example.xml");
        if (!xmlFile.exists()) {
            System.out.println("File not found!");
            return;
        }

        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            System.out.println("Failed to create XMLReader");
            return;
        }

        SAXHandler handler = new SAXHandler();
        reader.setContentHandler(handler);

        try {
            reader.parse(xmlFile);
        } catch (IOException e) {
            System.out.println("Failed to parse XML file");
            return;
        } catch (SAXException e) {
            System.out.println("XML parsing error: " + e.getMessage());
            return;
        }

        System.out.println("Parsed XML file successfully!");
    }
}