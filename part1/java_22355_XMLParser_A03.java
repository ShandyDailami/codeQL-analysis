import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.HashSet;
import java.util.Set;

public class java_22355_XMLParser_A03 {
    private static Set<String> seen = new HashSet<>();

    public static void main(String[] args) {
        String xmlFilePath = "src/main/resources/data.xml"; // replace with your file path
        File xmlFile = new File(xmlFilePath);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = dBuilder.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("*");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                String nodeName = eElement.getNodeName();
                if (!seen.contains(nodeName)) {
                    System.out.println("Node Name: " + nodeName);
                    System.out.println("Attributes: " + eElement.getAttributes().getLength());
                    for (int i = 0; i < eElement.getAttributes().getLength(); i++) {
                        System.out.println("Attribute Name: " + eElement.getAttributes().item(i).getNodeName());
                    }
                    seen.add(nodeName);
                }
            }
        }
    }
}