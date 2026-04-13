import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_17709_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("example.xml"); // Replace with your XML file path
        XMLReader xmlReader = null;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setEntityResolver(new MyEntityResolver());
            MyContentHandler handler = new MyContentHandler();
            xmlReader.setContentHandler(handler);

            xmlReader.parse(new FileInputStream(xmlFile));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}