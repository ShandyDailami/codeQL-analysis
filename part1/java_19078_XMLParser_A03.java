import java.io.File;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_19078_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            String filePath = "path/to/your/xml/file.xml"; // replace with your file path
            parseXML(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parseXML(String filePath) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.parse(new File(filePath));
        doc.getDocumentElement().normalize();

        System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());

        Map<String, List<Element>> attributes = doc.getElementsByTagName("*").iterator().next().getAttributes();
        for (Map.Entry<String, List<Element>> entry : attributes.entrySet()) {
            String attributeName = entry.getKey();
            List<Element> attributeValues = entry.getValue();
            System.out.println("Attribute: " + attributeName);
            for (Element attributeValue : attributeValues) {
                System.out.println("-> " + attributeValue.getTextContent());
            }
        }

        NodeList nodeList = doc.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            System.out.println("Node: " + node.getNodeName());
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("-> " + element.getTextContent());
            }
        }
    }
}