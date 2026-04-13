import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_13999_XMLParser_A01 {
    public static void main(String[] args) {
        // Step 1: Create a DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        // Step 2: Get a DocumentBuilder for the factory
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Step 3: Parse the XML file into a Document object
        Document doc = builder.parse(new File("sample.xml"));

        // Step 4: Access the XML elements and attributes
        // In this case, let's assume the XML file contains a single element with a single attribute
        doc.getDocumentElement().normalize();
        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        // Step 5: Handle the document
        // This is a very minimalist approach to handle the document. In a real-world application, you would likely want to handle errors and more complex XML structures
        System.out.println("Document parsing complete.");
    }
}