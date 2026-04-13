import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileReader;
import java.io.IOException;

public class java_06539_XMLParser_A03 {

    public static void main(String[] args) {
        String filePath = "path_to_your_xml_file.xml"; // replace with your file path
        parseXML(filePath);
    }

    public static void parseXML(String filePath) {
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            printXML(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printXML(Document doc) {
        NodeList nList = doc.getElementsByTagName("*");
        for (int temp = 0; temp != nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("Current Element : " + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                printElement(eElement);
            }
        }
    }

    public static void printElement(Element eElement) {
        System.out.println("Element : " + eElement.getTagName());
        NodeList childNodes = eElement.getChildNodes();
        for (int temp = 0; temp != childNodes.getLength(); temp++) {
            Node nNode = childNodes.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement2 = (Element) nNode;
                printElement(eElement2);
            }
            System.out.println("Child Node : " + nNode.getNodeName() + " : " + nNode.getTextContent());
        }
    }
}