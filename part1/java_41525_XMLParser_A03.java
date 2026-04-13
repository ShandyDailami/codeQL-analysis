import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_41525_XMLParser_A03 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();

        List<String> names = getNodeNames(doc, "name");
        List<String> addresses = getNodeNames(doc, "address");
        List<String> phones = getNodeNames(doc, "phone");

        // Print the results
        System.out.println("Names: " + names);
        System.out.println("Addresses: " + addresses);
        System.out.println("Phones: " + phones);
    }

    private static List<String> getNodeNames(Document doc, String nodeName) {
        NodeList nodeList = doc.getElementsByTagName(nodeName);
        List<String> nodeValues = null;

        switch(nodeName) {
            case "name":
                nodeValues = getNodeValues(nodeList, "firstname", "lastname");
                break;
            case "address":
                nodeValues = getNodeValues(nodeList, "street", "city", "state", "country");
                break;
            case "phone":
                nodeValues = getNodeValues(nodeList, "home", "work", "mobile");
                break;
        }

        return nodeValues;
    }

    private static List<String> getNodeValues(NodeList nodeList, String... nodeNames) {
        List<String> nodeValues = null;

        for(Node node : nodeList) {
            if(node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                nodeValues = new NodeValues(element, nodeNames).getValues();
            }
        }

        return nodeValues;
    }
}