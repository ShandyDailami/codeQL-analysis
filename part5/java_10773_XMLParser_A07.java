import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_10773_XMLParser_A07 {
    public static void main(String[] args) {
        String xmlFile = "src/main/resources/example.xml"; // path to your XML file
        File xmlFilePath = new File(xmlFile);

        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            XmlParserHandler handler = new XmlParserHandler();
            reader.setContentHandler(handler);
            reader.parse(xmlFilePath);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}