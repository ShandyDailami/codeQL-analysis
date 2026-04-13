import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

public class java_34105_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("note");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Element eElement = (Element) nList.item(temp);

                System.out.println("--------");
                System.out.println("ID: " + eElement.getAttribute("id"));

                NodeList childNodes = eElement.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
                        Element child = (Element) childNodes.item(j);
                        System.out.println("Child's node name: " + child.getNodeName());
                        System.out.println("Child's node value: " + child.getNodeValue());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}