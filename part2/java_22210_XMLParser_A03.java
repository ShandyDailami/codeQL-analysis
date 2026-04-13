import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_22210_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a factory for building DOM-related objects
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            // Create a builder for handling our XML
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Parse our XML file
            Document doc = builder.parse(new File("path_to_your_xml_file.xml"));
            
            // Get all the 'item' nodes
            NodeList items = doc.getElementsByTagName("item");
            
            // Loop through each 'item' node and print its text
            for (int i = 0; i < items.getLength(); i++) {
                System.out.println("Item " + (i + 1) + ": " + items.item(i).getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}