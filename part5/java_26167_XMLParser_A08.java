import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_26167_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("src/main/resources/sample.xml");
        SAXParserHandler handler = new SAXParserHandler();
        XMLReader reader;

        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}