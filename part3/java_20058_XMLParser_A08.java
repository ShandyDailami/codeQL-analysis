import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_20058_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file.xml");
        parseXML(xmlFile);
    }

    private static void parseXML(File xmlFile) {
        XMLReader reader;
        DefaultHandler handler = new DefaultHandler();

        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(xmlFile.toURI().toString());
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        handler.startDocument();
        handler.endDocument();
    }
}