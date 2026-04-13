import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_14217_XMLParser_A03 {

    public static void main(String[] args) {
        File xmlFile = new File("path/to/your/xml/file.xml");
        parseXML(xmlFile);
    }

    public static void parseXML(File xmlFile) {
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