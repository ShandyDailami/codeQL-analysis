import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_23386_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");  // replace with your XML file
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(xmlFile);
            printElementNamesAndAttributes(document);

            document.getDocumentElement().normalize();
            System.out.println("\n-------------------\n");
            printElementNamesAndAttributes(document);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElementNamesAndAttributes(Document document) {
        NodeList nodeList = document.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Element: " + element.getTagName());
                System.out.println("Attributes:");
                NodeList attributeList = element.getAttributes();
                for (int j = 0; j < attributeList.getLength(); j++) {
                    Node attributeNode = attributeList.item(j);
                    System.out.println("Attribute Name: " + attributeNode.getNodeName() + ", Attribute Value: " + attributeNode.getTextContent());
                }
            }
        }
    }
}