import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_16993_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("example.xml"); // replace with your xml file path
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("*");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Element: " + element.getNodeName());
                    System.out.println("Attributes:");
                    NodeList attrList = element.getAttributes();
                    for (int j = 0; j < attrList.getLength(); j++) {
                        Node attrNode = attrList.item(j);
                        System.out.println("   " + attrNode.getNodeName() + "=" + attrNode.getTextContent());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}