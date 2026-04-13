import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_24636_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Load the XML file
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            // Find the root element (element with no child nodes)
            doc.getDocumentElement().normalize();

            // Print out the name and value of each element
            NodeList nList = doc.getElementsByTagName("element");
            for (int temp = 0; temp != nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Element: " + eElement.getTagName());
                    System.out.println("Value: " + eElement.getFirstChild().getNodeValue());
                }
            }

            // Close the parser
            dBuilder.detachNode(doc.getFirstChild());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}