import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_09078_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Create a new factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use factory to create a new document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file into a Document object
            Document doc = builder.parse(new File("myfile.xml"));

            // Get all the nodes
            NodeList nlist = doc.getElementsByTagName("item");

            // Iterate over all nodes
            for (int i = 0; i < nlist.getLength(); i++) {
                Node node = nlist.item(i);
                System.out.println("Item: " + node.getTextContent());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}