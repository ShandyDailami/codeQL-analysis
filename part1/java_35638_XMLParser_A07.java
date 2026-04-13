import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.security.KeyStore.SecretKeyAttribute;

public class java_35638_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml"); // Input XML file
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("item");
            
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String name = eElement.getAttribute("name");
                    String value = eElement.getAttribute("value");
                    System.out.println("Name: " + name + ", Value: " + value);
                }
            }
           
            System.out.println("XML Parsing Complete!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}