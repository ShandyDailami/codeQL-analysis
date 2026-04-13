import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileReader;

public class java_10302_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("example.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
            
            NodeList nList = doc.getElementsByTagName("*");
            for (int temp = 0; temp != nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("Element : " + nNode.getNodeName() + "  Value : " + nNode.getTextContent());
            }

            System.out.println("Parsing completed");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}