import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_36918_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();

            System.out.println("Root element : " + doc.getDocumentElement().getNodeName());

            printElement(doc, doc.getDocumentElement());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElement(Document doc, Element elem) {
        System.out.println("\nElement : " + elem.getNodeName());

        NodeList childNodes = elem.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);
            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                printElement(doc, (Element) childNode);
            } else if (childNode.getNodeType() == Node.TEXT_NODE) {
                System.out.println("Text Node : " + childNode.getNodeValue());
            }
        }

        NodeList attributes = elem.getAttributes();
        for (int i = 0; i < attributes.getLength(); i++) {
            Node attribute = attributes.item(i);
            System.out.println("Attribute : " + attribute.getNodeName() + "=" + attribute.getNodeValue());
        }
    }
}