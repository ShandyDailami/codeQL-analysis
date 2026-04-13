import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_08137_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Load the XML document
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            // Print all elements and attributes of the document
            NodeList nList = doc.getElementsByTagName("student");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nStudent " + (temp + 1));
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    // Print student name
                    System.out.println("Name: " + eElement.getAttribute("name"));

                    // Print student age
                    System.out.println("Age: " + eElement.getAttribute("age"));

                    // Print student grade
                    System.out.println("Grade: " + eElement.getAttribute("grade"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}