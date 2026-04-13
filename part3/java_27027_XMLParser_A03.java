import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_27027_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Load the XML file
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            // Extract and print the data
            NodeList nList = doc.getElementsByTagName("student");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nStudent Information: " + temp + "\n");

                Element eElement = (Element) nNode;

                // Print student data
                System.out.println("ID: " + eElement.getAttribute("id"));
                System.out.println("Name: " + eElement.getAttribute("name"));
                System.out.println("Age: " + eElement.getAttribute("age"));
            }

            System.out.println("\nXML Parsing Successful!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}