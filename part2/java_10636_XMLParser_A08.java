import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_10636_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Step 1: Create a factory for the DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            // Step 2: Use the factory to create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Step 3: Parse the XML file into a Document object
            Document doc = builder.parse("src/input.xml");
            
            // Here you can use the Document object to process the XML data
            // ...

            // Here's how you can handle exceptions
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}