import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_06478_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getElementsByTagName("root").item(0).getTextContent());

            NodeList nodeList = doc.getElementsByTagName("student");

            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node node = nodeList.item(temp);
                System.out.println("\n Student " + (temp + 1));
                System.out.println("Name: " + node.getChildNodes().item(1).getTextContent());
                System.out.println("Age: " + node.getChildNodes().item(3).getTextContent());
                System.out.println("Country: " + node.getChildNodes().item(5).getTextContent());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}