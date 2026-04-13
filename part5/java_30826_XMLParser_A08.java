import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_30826_XMLParser_A08 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: XMLParser filename");
            System.exit(1);
        }

        File inputFile = new File(args[0]);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        try {
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            printNode(doc, doc.getDocumentElement());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printNode(Document doc, Node node) {
        String prefixes[] = {"http://www.w3.org/2001/XMLSchema-instance"};
        NodeList nodeList = doc.getElementsByTagName("*", prefixes);

        for (int i = 0; i < nodeList.getLength(); i++) {
            printNode(doc, nodeList.item(i));
        }

        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            System.out.println("Tag Name: " + element.getTagName());

            NodeList attributes = element.getAttributes();
            for (int j = 0; j < attributes.getLength(); j++) {
                Node attribute = attributes.item(j);
                System.out.println("Attribute Name: " + attribute.getNodeName() + ", Value: " + attribute.getTextContent());
            }
        }
    }
}