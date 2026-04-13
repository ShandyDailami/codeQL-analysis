import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_30457_XMLParser_A01 {
    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();
        System.out.println("Root Element : " + doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("*");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nNode Name : " + nNode.getNodeName());
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("Element : " + eElement.getTagName());
                System.out.println("Attributes : ");
                for (int j = 0; j < eElement.getAttributeCount(); j++) {
                    System.out.println("Attribute : " + eElement.getAttributeNode(j).getNodeName() + " : " + eElement.getAttributeNode(j).getTextContent());
                }
                System.out.println("Child Nodes : ");
                NodeList children = eElement.getChildNodes();
                for (int j = 0; j < children.getLength(); j++) {
                    Node child = children.item(j);
                    if (child.getNodeType() == Node.ELEMENT_NODE) {
                        System.out.println("Child Node : " + child.getNodeName());
                    } else if (child.getNodeType() == Node.TEXT_NODE) {
                        System.out.println("Text Node : " + child.getNodeValue());
                    }
                }
            }
        }
    }
}