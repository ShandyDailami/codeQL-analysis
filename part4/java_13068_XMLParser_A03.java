import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_13068_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("sample.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            // Get the root element
            doc.getDocumentElement().normalize();
            System.out.println("Root Element : " + doc.getDocumentElement().getNodeName());

            // Traverse through each element
            NodeList nList = doc.getElementsByTagName("*");
            for (int temp = 0; temp != nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("Node Name : " + nNode.getNodeName());
            }
            System.out.println("End of parsing...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}