import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_04180_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlFilePath = "example.xml";  // replace with your xml file path
        parseXml(xmlFilePath);
    }

    private static void parseXml(String xmlFilePath) {
        File xmlFile = new File(xmlFilePath);
        if (!xmlFile.exists()) {
            System.out.println("Xml file does not exist: " + xmlFilePath);
            return;
        }

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            DefaultHandler handler = new DefaultHandler();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (IOException e) {
            System.out.println("Error reading xml file: " + xmlFilePath);
       
        } catch (SAXException e) {
            System.out.println("Error parsing xml file: " + xmlFilePath);
        }
    }
}