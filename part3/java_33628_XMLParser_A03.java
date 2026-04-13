import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_33628_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Create a factory for building a document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);
            
            // Use the factory to create a new document builder
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Parse the XML from the file
            Document doc = builder.parse("src/example.xml");
            
            // Print out the XML document
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            
        } catch (SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}