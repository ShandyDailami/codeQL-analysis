import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_01869_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the XML file
            Document doc = dBuilder.parse(new File("sample.xml"));

            // Get the root element
            doc.getDocumentElement().normalize();

            // Get all the elements in the document
            NodeList nList = doc.getElementsByTagName("*");

            // Iterate through all the elements
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                // Check if the node is an element
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    // Get the element name and print out the element
                    System.out.println("Element: " + eElement.getNodeName());

                    // Get the element value and print out the element
                    System.out.println("Element Value: " + eElement.getFirstChild().getNodeValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}