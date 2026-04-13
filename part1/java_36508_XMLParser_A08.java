import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_36508_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Load the XML file
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            // Print out the names of all the elements and attributes in the file
            printNodeNames(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printNodeNames(Document doc) {
        NodeList nList = doc.getElementsByTagName("*");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("Node Name: " + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("Attribute Count: " + eElement.getAttributeCount());
                for (int i = 0; i < eElement.getAttributeCount(); i++) {
                    System.out.println("Attribute " + i + ": " + eElement.getAttributeNode(i).getNodeName() + " = " + eElement.getAttributeNode(i).getTextContent());
                }
            }
        }
    }
}