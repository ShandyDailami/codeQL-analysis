import java.io.FileInputStream;
import java.io.InputStream;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_41096_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlFile = "example.xml"; // replace with your xml file
        validateXML(xmlFile);
    }

    public static void validateXML(String xmlFile) {
        try {
            InputStream inputStream = new FileInputStream(xmlFile);
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(new SecureXMLContentHandler());
            xmlReader.parse(inputStream);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}