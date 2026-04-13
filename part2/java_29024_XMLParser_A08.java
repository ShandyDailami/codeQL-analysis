import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_29024_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the XML file
            Document doc = dBuilder.parse(new File("sample.xml"));

            // Get the root element of the document
            doc.getDocumentElement().normalize();

            // Print all elements and attributes of the document
            printElements(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElements(Document doc) {
        NodeList nList = doc.getElementsByTagName("*");
        for (int temp = 0; temp != nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("Element : " + eElement.getNodeName());
                System.out.println("Attributes : ");
                printAttributes(eElement);
            }
        }
    }

    private static void printAttributes(Element eElement) {
        for (int temp = 0; temp != eElement.getAttributes().getLength(); temp++) {
            System.out.println("Attribute : " + eElement.getAttributes().item(temp).getNodeName() + " = " + eElement.getAttributes().item(temp).getNodeValue());
        }
    }
}