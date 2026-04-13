import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_17728_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = null;
        try {
            document = builder.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        document.getDocumentElement().normalize();
        System.out.println("Root Element: " + document.getDocumentElement().getNodeName());
        printNode(document.getDocumentElement(), 1);
    }

    private static void printNode(Node node, int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print(" ");
        }
        System.out.print(node.getNodeName());
        if (node.getChildNodes().getLength() > 0) {
            System.out.println(":");
            for (int i = 0; i < node.getChildNodes().getLength(); i++) {
                Node child = node.getChildNodes().item(i);
                printNode(child, indent + 2);
            }
        } else {
            System.out.println(": " + node.getTextContent());
        }
    }
}