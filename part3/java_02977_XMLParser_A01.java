import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_02977_XMLParser_A01 {

    public static void main(String[] args) {
        File xmlFile = new File("example.xml"); // replace with your XML file
        parse(xmlFile);
    }

    public static void parse(File xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = builder.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        doc.getDocumentElement().normalize();
        System.out.println("Root element : " + doc.getDocumentElement().getNodeName());

        printNodes(doc.getElementsByTagName("*"));
    }

    public static void printNodes(NodeList nodes) {
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("--------------------");
                System.out.println("Node name : " + element.getNodeName());
                System.out.println("Node value : " + element.getNodeValue());
                printAttributes(element.getAttributes());
            }
            printNodes(node.getChildNodes());
        }
    }

    public static void printAttributes(javax.xml.dom.Attr[] attrs) {
        for (int i = 0; i < attrs.length; i++) {
            javax.xml.dom.Attr attr = attrs[i];
            System.out.println("Attribute name : " + attr.getName());
            System.out.println("Attribute value : " + attr.getValue());
        }
    }
}