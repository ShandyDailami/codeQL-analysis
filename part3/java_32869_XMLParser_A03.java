import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_32869_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Load XML document
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            // Normalize the document
            doc.getDocumentElement().normalize();

            // Select names and quantities
            NodeList nl = doc.getElementsByTagName("name");
            for (int temp = 0; temp < nl.getLength(); temp++) {
                Node node = nl.item(temp);
                System.out.println("Name: " + node.getFirstChild().getNodeValue());

                nl = doc.getElementsByTagName("quantity");
                for (int i = 0; i < nl.getLength(); i++) {
                    Node node2 = nl.item(i);
                    System.out.println("Quantity: " + node2.getFirstChild().getNodeValue());
               
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}