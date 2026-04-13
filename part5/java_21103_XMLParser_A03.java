import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_21103_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a factory for building DOM tree
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            // Use the factory to build a document builder
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Parse the input file and store in the DOM tree
            Document document = builder.parse("input.xml");
            
            // TODO: Parse the DOM tree and do something with it.
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}