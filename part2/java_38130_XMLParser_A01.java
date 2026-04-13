import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_38130_XMLParser_A01 {

    public static void main(String[] args) {
        File inputFile = new File("sample.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = dBuilder.parse(inputFile);
        } catch (IOException e) {
            System.out.println("Error parsing the XML file");
        }

        doc.getDocumentElement().normalize();

        System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("*");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nNode Name: " + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("Attribute 'id': " + eElement.getAttribute("id"));
                System.out.println("Attribute 'class': " + eElement.getAttribute("class"));
                System.out.println("Element Content: " + eElement.getTextContent());
            }
        }
    }
}