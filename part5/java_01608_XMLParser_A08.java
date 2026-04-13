import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileReader;

public class java_01608_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("input.xml"); // replace with your xml file
            FileReader reader = new FileReader(xmlFile);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element : " + doc.getDocumentElement().getNodeName());

            // Get all child nodes of the root node
            NodeList nList = doc.getElementsByTagName("*");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nNode Name : " + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Tag name : " + eElement.getTagName());
                    System.out.println("Value : " + eElement.getFirstChild().getNodeValue());
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}