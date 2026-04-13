import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_28593_XMLParser_A08 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        File inputFile = new File("input.xml");
        Document document = null;
        try {
            document = builder.parse(inputFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        document.getDocumentElement().normalize();

        System.out.println("Root element : " + document.getDocumentElement().getNodeName());

        NodeList nList = document.getElementsByTagName("item");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("  - Node : " + temp + " - " + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("    Name: " + eElement.getAttribute("name"));
                System.out.println("    Value: " + eElement.getAttribute("value"));
            }
        }
    }
}