import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_01505_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_file.xml");
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            SAXParserHandler handler = new SAXParserHandler();
            reader.setContentHandler(handler);
            reader.parse(xmlFile.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}