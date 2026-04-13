import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.File;

public class java_24190_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        parse(xmlFile);
    }

    public static void parse(File xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            printElementsAndAttributes(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElementsAndAttributes(Document doc) {
        NodeList nodeList = doc.getElementsByTagName("*");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Element: " + element.getNodeName());

                NodeList attributeList = element.getAttributes();

                for (int j = 0; j < attributeList.getLength(); j++) {
                    Node attributeNode = attributeList.item(j);
                    System.out.println("Attribute: " + attributeNode.getNodeName() + "=" + attributeNode.getTextContent());
                }
            }
        }
    }
}