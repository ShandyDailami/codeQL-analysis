import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_11589_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root element : " + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("item");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\n  Item - " + (temp + 1));
                System.out.println("  Name : " + getNodeValue(nNode.getAttributes().getNamedItem("name")));
                System.out.println("  Description : " + getNodeValue(nNode.getAttributes().getNamedItem("description")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static String getNodeValue(Node node) {
        if (node != null) {
            return node.getNodeValue();
        } else {
            return "";
        }
    }
}