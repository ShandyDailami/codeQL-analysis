import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_23200_XMLParser_A07 {

    public static void main(String[] args) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document doc = builder.parse(new File("sample.xml"));
            doc.getDocumentElement().normalize();
            printNode(doc, null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printNode(Node node, String indent) {
        if (node != null && node.getNodeType() == Node.ELEMENT_NODE) {
            for (int i = 0; i < node.getChildNodes().getLength(); i++) {
                Node child = node.getChildNodes().item(i);
                if (child.getNodeType() == Node.COMMENT_NODE || child.getNodeType() == Node.DOCUMENT_NODE) {
                    continue;
                }
                System.out.print(indent + child.getNodeName());

                if (child.getChildNodes().getLength() > 0) {
                    System.out.print(" ");
                    printNode(child, indent);
                } else {
                    System.out.println();
                }
            }
        }
    }
}