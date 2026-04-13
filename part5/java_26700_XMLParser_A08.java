import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.security.InvalidParameterException;

public class java_26700_XMLParser_A08 {
    public static void main(String[] args) {
        String xmlFilePath = "/path/to/your/xml/file.xml"; // Replace with your actual file path
        parseXMLFile(xmlFilePath);
    }

    public static void parseXMLFile(String xmlFilePath) {
        try {
            File xmlFile = new File(xmlFilePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            printElementNames(doc);
        } catch (Exception e) {
            System.out.println("Error parsing the XML file: " + e.getMessage());
        }
    }

    public static void printElementNames(Document doc) {
        NodeList nList = doc.getElementsByTagName("*");
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("Element name: " + eElement.getTagName());
            }
        }
    }
}