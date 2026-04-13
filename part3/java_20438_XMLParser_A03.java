import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_20438_XMLParser_A03 {

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

            // Print all the elements in the document
            printElements(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printElements(Document doc) {
        NodeList nList = doc.getElementsByTagName("element");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;

                // Print the name and the value of the node
                System.out.println("Element Name: " + eElement.getNodeName());
                System.out.println("Element Value: " + eElement.getFirstChild().getNodeValue());
            }
        }
    }
}