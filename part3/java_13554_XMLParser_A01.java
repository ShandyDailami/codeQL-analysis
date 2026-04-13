import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_13554_XMLParser_A01 {

    public static void main(String[] args) {

        File xmlFile = new File("src/sample.xml");

        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();

            XMLReaderHandler handler = new XMLReaderHandler();
            reader.setContentHandler(handler);

            reader.parse(xmlFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}