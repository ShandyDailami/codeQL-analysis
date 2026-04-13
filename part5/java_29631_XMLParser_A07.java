import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_29631_XMLParser_A07 {

    public static void main(String[] args) {
        String xmlFile = "path/to/your/xml/file.xml"; // replace with your xml file path
        parseXml(xmlFile);
    }

    public static void parseXml(String xmlFile) {
        File xml = new File(xmlFile);
        XMLReader reader;
        DefaultHandler handler = new DefaultHandler();

        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(xml.toURI().toString());
        } catch (SAXException e) {
            e.printStackTrace();
       
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}