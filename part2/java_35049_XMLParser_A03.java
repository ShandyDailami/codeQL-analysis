import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_35049_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml"); // replace with your XML file path
            
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Parse the XML file and load it into a Document object
            Document document = builder.parse(xmlFile);
            
            // Print out the parsed information
            System.out.println("Parsed XML File successfully");
            System.out.println("Root element: " + document.getDocumentElement().getNodeName());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}