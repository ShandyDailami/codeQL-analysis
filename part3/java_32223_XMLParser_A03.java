import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_32223_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a factory for building a document builder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Create a builder from the factory
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Parse the input file into a Document object
            Document doc = builder.parse("input.xml");
            
            // Here, you can manipulate the document or its elements
            // You can also use the document's methods to query or modify it
            // For example, here we simply print out the document's name
            System.out.println("Document name: " + doc.getDocumentElement().getNodeName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}