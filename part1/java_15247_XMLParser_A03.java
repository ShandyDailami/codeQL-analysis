import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_15247_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Load XML document
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            // Normalize the document
            doc.getDocumentElement().normalize();

            // Print all the node names and their corresponding values
            printNodes(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printNodes(Document doc) {
        NodeList nList = doc.getElementsByTagName("*");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("Tag : " + eElement.getTagName() + "  Value : " + eElement.getFirstChild().getNodeValue());
            }
        }
    }
}