import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.File;
import java.io.IOException;

public class java_40193_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("example.xml");  // Your XML file path
            XMLReader reader = XMLReaderFactory.createXMLReader();
            
            // Create a custom handler to process the XML data
            XmlHandler handler = new XmlHandler();
            reader.setContentHandler(handler);
            
            // Parse the XML file
            reader.parse(xmlFile);
            
            // Print the parsed data
            for (String data : handler.getData()) {
                System.out.println(data);
            }
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}