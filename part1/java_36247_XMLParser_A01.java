import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_36247_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            FileInputStream input = new FileInputStream("example.xml");
            XMLReader reader = XMLReaderFactory.createXMLReader();
            
            SAXParserHandler handler = new SAXParserHandler();
            reader.setContentHandler(handler);
            
            reader.parse(input);
            
            System.out.println("Successfully parsed the XML file.");
        } catch (FileNotFoundException e) {
            System.out.println("XML file not found.");
        } catch (SAXException e) {
            System.out.println("Error parsing the XML file.");
        }
    }
}