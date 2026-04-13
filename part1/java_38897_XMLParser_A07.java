import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_38897_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a new DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            
            // Use the new factory to create a new DocumentBuilder
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            
            // Parse the XML file and store in the Document object
            Document doc = dBuilder.parse(new File("sample.xml"));
            
            // Get the root element
            doc.getDocumentElement().normalize();
            
            // Print all the nodes in the document
            printNodes(doc);
            
            // Close the DocumentBuilder
            dBuilder.getClass().cast(doc).close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printNodes(Document doc) {
        NodeList nList = doc.getElementsByTagName("node");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("Node " + (temp + 1) + ": " + nNode.getTextContent());
        }
    }
}