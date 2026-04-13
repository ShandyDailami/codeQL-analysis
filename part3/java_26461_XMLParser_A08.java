import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXHandler;
import java.io.File;
import java.io.IOException;

public class java_26461_XMLParser_A08 {
    public static void main(String[] args) {
        SAXHandler saxHandler = new SAXHandler();
        File xmlFile = new File("path_to_your_xml_file.xml");
        
        try {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(saxHandler);
            xmlReader.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}