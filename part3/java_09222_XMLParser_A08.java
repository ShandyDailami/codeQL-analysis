import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_09222_XMLParser_A08 {
    
    public void parseXML(String fileName) {
        try {
            File xmlFile = new File(fileName);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            
            // Your parsing code here

        } catch (Exception e) {
            System.out.println("An error occurred while parsing the XML file.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SensitiveDataParser parser = new SensitiveDataParser();
        parser.parseXML("path_to_your_file.xml");
    }
}