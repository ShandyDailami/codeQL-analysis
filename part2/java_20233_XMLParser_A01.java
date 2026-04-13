import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_20233_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("user");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    // Extract and print the data
                    String username = eElement.getAttribute("username");
                    String password = eElement.getAttribute("password");

                    System.out.println("Username: " + username);
                    System.out.println("Password: " + password);
                }
            }

            // Add your code here to handle the security sensitive operations
            // This is a placeholder for your code

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}