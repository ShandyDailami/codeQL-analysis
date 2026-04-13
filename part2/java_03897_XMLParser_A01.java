import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_03897_XMLParser_A01 {

    public static void main(String[] args) {

        try {
            // Setup DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Create a new DocumentBuilder from the factory
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the XML file into a Document object
            Document doc = dBuilder.parse("BrokenAccessControl.xml");

            System.out.println("Document Loaded successfully...");

            // Here we will print all the names of all the elements in the document
            doc.getElementsByTagName("*").item(0).getNodeName();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}