import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_11855_XMLParser_A01 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("example.xml")); // replace with your xml file

            doc.getDocumentElement().normalize();
            printNode(doc);

            System.out.println("\nEnd of the program.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printNode(Node node) {
        if (node.hasChildNodes()) {
            for (Node child = node.getFirstChild(); child != null; child = child.getNextSibling()) {
                printNode(child);
            }
        } else {
            System.out.println(node.getNodeName());
        }
    }
}