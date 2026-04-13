import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_02710_XMLParser_A08 {

    public static void main(String[] args) {

        try {
            // Create a factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use the factory to create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the input file into a Document
            Document document = builder.parse(new File("input.xml"));

            // Get all elements in the document
            NodeList nodeList = document.getElementsByTagName("*");

            // Loop through all elements
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Element: " + element.getTagName());
                    System.out.println("Attributes: " + element.getAttributes().getLength());
                    // Get attributes and print them
                    for (int j = 0; j < element.getAttributes().getLength(); j++) {
                        System.out.println("Attribute Name: " + element.getAttributes().item(j).getNodeName() + " Attribute Value: " + element.getAttributes().item(j).getNodeValue());
                    }
                    // Get child nodes and print them
                    System.out.println("Child Nodes: " + element.getChildNodes().getLength());
                    for (int k = 0; k < element.getChildNodes().getLength(); k++) {
                        Node child = element.getChildNodes().item(k);
                        if (child.getNodeType() == Node.TEXT_NODE) {
                            System.out.println("Child Node: " + child.getNodeValue());
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}