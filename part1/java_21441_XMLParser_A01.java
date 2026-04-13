import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.Iterator;

public class java_21441_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("student");
            Iterator<Node> nodeIterator = nList.iterator();

            while (nodeIterator.hasNext()) {
                Node node = nodeIterator.nextNode();
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    System.out.println("Student ID: " + eElement.getAttribute("id"));
                    System.out.println("Student Name: " + eElement.getAttribute("name"));
                    System.out.println("Student Age: " + eElement.getAttribute("age"));
                    System.out.println("Student Course: " + eElement.getAttribute("course"));
                }
            }

            System.out.println("XML Parsing Complete!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}