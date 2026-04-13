import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_40670_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("example.xml");
        parseFile(xmlFile);
    }

    private static void parseFile(File xmlFile) {
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new XmlContentHandler());
            reader.parse(xmlFile.toURI().toString());
        } catch (SAXException e) {
            System.out.println("SAXException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }

}