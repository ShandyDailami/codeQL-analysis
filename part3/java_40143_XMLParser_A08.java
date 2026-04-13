import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileWriter;
import java.io.IOException;

public class java_40143_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            
            NodeList nList = doc.getElementsByTagName("student");
            
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nStudent Details: ");
                System.out.println("Name: " + getElementValue(nNode, "name"));
                System.out.println("Id: " + getElementValue(nNode, "id"));
                System.out.println("Course: " + getElementValue(nNode, "course"));
            }
            
            printStudent(doc);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static String getElementValue(Node node, String elementName){
        NodeList nList = node.getElementsByTagName(elementName);
        String text = "";
        if (nList != null && nList.getLength() > 0){
            Node nNode = nList.item(0);
            text = nNode.getTextContent();
        }
        return text;
    }
    
    public static void printStudent(Document doc){
        NodeList nodeList = doc.getElementsByTagName("student");
        for (int temp = 0; temp < nodeList.getLength(); temp++) {
            Node node = nodeList.item(temp);
            System.out.println("\nStudent Details: ");
            System.out.println("Name: " + getElementValue(node, "name"));
            System.out.println("Id: " + getElementValue(node, "id"));
            System.out.println("Course: " + getElementValue(node, "course"));
        }
    }
}