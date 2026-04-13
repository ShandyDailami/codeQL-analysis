import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_30459_XMLParser_A03 {

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("student");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) node;
                String name = e.getElementsByTagName("name").item(0).getTextContent();
                String age = e.getElementsByTagName("age").item(0).getTextContent();
                System.out.println("Name: " + name + ", Age: " + age);
            }
        }
    }
}