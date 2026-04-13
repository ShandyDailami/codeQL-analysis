import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_17373_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_file.xml");
        parseXml(xmlFile);
    }

    private static void parseXml(File xmlFile) {
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new SecurityHandler());
            reader.parse(xmlFile.toURI().toString());
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}