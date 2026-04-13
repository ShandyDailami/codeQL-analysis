import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_39955_XMLParser_A01 {

    public static void main(String[] args) {
        File xmlFile = new File("security-sensitive-info.xml"); // replace with your XML file path

        try {
            SAXParserHandler handler = new SAXParserHandler();
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(xmlFile.toURI().toString());
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

}