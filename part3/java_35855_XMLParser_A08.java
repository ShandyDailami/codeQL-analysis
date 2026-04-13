import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entries.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_35855_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_file.xml");
        DefaultHandler handler = new DefaultHandler();

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}