import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_02783_XMLParser_A01 {
    public static void main(String[] args) {
        File xmlFile = new File("example.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            doc.getDocumentElement().normalize();
            printElementAndAttributes(doc, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printElementAndAttributes(Document doc, Element elem) {
        NodeList nodes = doc.getElementsByTagName(elem == null ? "*" : elem.getTagName());

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                printElementAndAttributes(doc, element);
            } else if (node.getNodeType() == Node.ATTRIBUTE_NODE) {
                Element element = (Element) node.getParentNode();
                System.out.println("Attribute: " + node.getNodeName() + " = " + node.getTextContent());
            }
        }
    }
}