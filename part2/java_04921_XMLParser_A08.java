import java.io.File;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_04921_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Create a factory for building a document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Load the XML file
            File file = new File("your_xml_file.xml");
            Document document = builder.parse(file);
            
            // Start XML parsing
            startParsing(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void startParsing(Document document) {
        // Get all the elements
        List<NodeList> elements = document.getElementsByTagName("*");
        for (int i = 0; i < elements.size(); i++) {
            // Get all the child nodes
            List<org.w3c.dom.Node> childNodes = elements.get(i).getChildNodes();
            for (int j = 0; j < childNodes.size(); j++) {
                // Get attributes
                Map<String, String> attributes = childNodes.get(j).getAttributes();
                for (Map.Entry<String, String> entry : attributes.entrySet()) {
                    System.out.println("Attribute: " + entry.getKey() + ", Value: " + entry.getValue());
                }
            }
        }
    }
}