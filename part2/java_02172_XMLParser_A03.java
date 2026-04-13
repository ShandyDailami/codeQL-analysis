import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_02172_XMLParser_A03 {

    public static void main(String[] args) {
        String filePath = "path_to_your_xml_file.xml";
        parseXML(filePath);
    }

    public static void parseXML(String filePath) {
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        try {
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("element");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    // Accessing and printing the elements' data
                    String elementData = eElement.getAttribute("attribute");
                    System.out.println("Data of attribute: " + elementData);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}