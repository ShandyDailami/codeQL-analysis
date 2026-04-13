import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_20707_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("src/main/resources/example.xml");
            XMLReader reader = XMLReaderFactory.createXMLReader();

            SAXHandler handler = new SAXHandler();
            reader.setContentHandler(handler);

            reader.parse(xmlFile);

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}