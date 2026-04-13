import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_31389_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Load XML document
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            // Retrieve values
            NodeList nList = doc.getElementsByTagName("name");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("Name: " + nNode.getTextContent());

                NodeList aList = doc.getElementsByTagName("age");
                for (int i = 0; i < aList.getLength(); i++) {
                    Node aNode = aList.item(i);
                    System.out.println("Age: " + aNode.getTextContent());
               
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}