import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_35758_XMLParser_A01 {

    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file");

        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            MyContentHandler handler = new MyContentHandler();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

}