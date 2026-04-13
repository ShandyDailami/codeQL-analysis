import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_01830_XMLParser_A03 {

    public static void parseFile(String filePath) {
        File xmlFile = new File(filePath);
        if (!xmlFile.exists()) {
            System.out.println("File does not exist.");
            return;
        }

        DefaultHandler handler = new DefaultHandler();
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(xmlFile.getAbsolutePath());
        } catch (SAXException | IOException e) {
            System.out.println("Error parsing the XML file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Test file path
        String filePath = "src/main/resources/injection.xml";
        parseFile(filePath);
    }
}