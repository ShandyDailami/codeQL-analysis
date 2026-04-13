import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_33313_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Get a DocumentBuilder from the factory
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the document into a DOM
            Document doc = dBuilder.parse(new File("sample.xml"));

            // Get all the elements in the document
            NodeList nList = doc.getElementsByTagName("*");

            // Iterate over all elements
            for (int temp = 0; temp < nList.getLength(); temp++) {
                // Print out the name and type of each node
                Node n = nList.item(temp);
                System.out.println(n.getNodeName() + " is " + n.getNodeType());
            }

            // Close the document
            doc.getDocumentElement().normalize();

        } catch (Exception e) {
            e.printStackTrace();
       
        }
    }
}