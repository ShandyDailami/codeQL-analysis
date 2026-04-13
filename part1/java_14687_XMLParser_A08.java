import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_14687_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Load the XML document
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            // Extract and print the node values
            NodeList nList = doc.getElementsByTagName("student");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("Student " + (temp + 1));
                Element eElement = (Element) nNode;

                // Extract and print each attribute's value
                System.out.print("ID: " + eElement.getAttribute("id"));
                System.out.print(", Name: " + eElement.getAttribute("name"));
                System.out.println("");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}