import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_16871_XMLParser_A01 {
    public static void main(String[] args) {
        String fileName = "example.xml";
        File inputFile = new File(fileName);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document doc = builder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("item");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("  Processing 'item' at Record " + temp + " ...");

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    System.out.println("  Item Name: " + eElement.getAttribute("name"));
                    System.out.println("  Item Price: " + eElement.getAttribute("price"));
                }
            }

            System.out.println("  Completed parsing 'example.xml'");

        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}