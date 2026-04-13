import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_06869_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("example.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            NodeList nodes = doc.getElementsByTagName("*");

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Node name: " + element.getNodeName());
                    System.out.println("Node value: " + element.getNodeValue());
                    System.out.println("Node attributes: ");
                    for (int j = 0; j < element.getAttributes().getLength(); j++) {
                        System.out.println("Attribute: " + element.getAttributes().item(j).getNodeName() + " = " + element.getAttributes().item(j).getNodeValue());
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}