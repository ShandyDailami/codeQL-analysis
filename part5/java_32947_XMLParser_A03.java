import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_32947_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Create a factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            // Create a document builder
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Parse the XML file
            Document document = builder.parse("src/main/resources/sample.xml");
            
            // Print out the XML document
            document.getDocumentElement().normalize();
            System.out.println("Root Element: " + document.getElements().getNamedItem("root"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}