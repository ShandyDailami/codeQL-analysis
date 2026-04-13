import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_39560_XMLParser_A01 {

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        parse(inputFile);
    }

    public static void parse(File inputFile) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = null;
        try {
            doc = dBuilder.parse(inputFile);
        } catch (Exception e) {
            e.printStackTrace();
       
        }
        doc.getDocumentElement().normalize();
        System.out.println("Root Element : " + doc.getElementsByTagName("").item(0).getTextContent());
        printAllElements(doc.getElementsByTagName(""));
    }

    private static void printAllElements(Node node) {
        if (node.hasChildNodes()) {
            for (int i = 0; i < node.getChildNodes().getLength(); i++) {
                Node childNode = node.getChildNodes().item(i);
                if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                    System.out.println("Element : " + childNode.getNodeName());
                    printAllElements(childNode);
                } else if (childNode.getNodeType() == Node.TEXT_NODE) {
                    System.out.println("Text : " + childNode.getNodeValue());
                }
            }
        }
    }
}