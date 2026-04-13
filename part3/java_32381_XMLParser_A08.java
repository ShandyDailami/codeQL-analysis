import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_32381_XMLParser_A08 {

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = dBuilder.parse(inputFile);
        } catch (Exception e) {
            e.printStackTrace();
       
        }

        doc.getDocumentElement().normalize();

        System.out.println("Root Element : " + doc.getElementsByTagName("element").item(0).getTextContent());

        NodeList nList = doc.getElementsByTagName("node");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            System.out.println("Node " + (temp + 1) + ": " + node.getTextContent());
        }

        NodeList childNodes = doc.getElementsByTagName("childnode");
        for (int temp = 0; temp < childNodes.getLength(); temp++) {
            Node childNode = childNodes.item(temp);
            System.out.println("Child Node " + (temp + 1) + ": " + childNode.getTextContent());
        }
    }
}