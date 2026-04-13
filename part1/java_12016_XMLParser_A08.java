import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class java_12016_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Load the XML file
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            // Print out the parsed data
            printData(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printData(Document doc) {
        NodeList nList = doc.getElementsByTagName("item");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                // Print out the data
                System.out.println("Item: " + eElement.getAttribute("id"));
                System.out.println("Name: " + eElement.getAttribute("name"));
                System.out.println("Price: " + eElement.getAttribute("price"));
            }
        }
    }
}