import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_14187_XMLParser_A08 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        File inputFile = new File("input.xml");
        Document document = null;

        try {
            document = builder.parse(inputFile);
            document.getDocumentElement().normalize();
            printElementsAndAttributes(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElementsAndAttributes(Document document) {
        NodeList nodeList = document.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Element name: " + element.getTagName());
                NodeList attributeList = element.getAttributes();
                for (int j = 0; j < attributeList.getLength(); j++) {
                    Node attribute = attributeList.item(j);
                    System.out.println("Attribute name: " + attribute.getNodeName() + ", value: " + attribute.getNodeValue());
                }
            }
        }
    }
}