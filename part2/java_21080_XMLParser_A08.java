import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_21080_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Load XML document
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            // normalize the document
            doc.getDocumentElement().normalize();

            // Print all the element nodes
            printElementNodes(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElementNodes(Document doc) {
        NodeList nList = doc.getElementsByTagName("*");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println("Element : " + nNode.getNodeName());
            }
        }
    }
}