import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_37518_XMLParser_A01 {

    public static void main(String[] args) {
        File xmlFile = new File("example.xml"); // Replace with your XML file path
        parseXML(xmlFile);
    }

    private static void parseXML(File xmlFile) {
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new XMLContentHandler());
            reader.parse(xmlFile.toURI().toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}