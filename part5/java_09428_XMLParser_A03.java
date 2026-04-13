import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sun.security.util.SecurityConstants;

public class java_09428_XMLParser_A03 {
    public static void main(String[] args) {
        String fileName = "sample.xml";
        parseXML(fileName);
    }

    private static void parseXML(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = null;
        try {
            doc = builder.parse(new File(fileName));
        } catch (ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }

        doc.getDocumentElement().normalize();
        System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
        printNodes(doc.getDocumentElement(), 0);
    }

    private static void printNodes(Element node, int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("  ");
        }
        System.out.println("Element : " + node.getNodeName());
        if (node.hasChildNodes()) {
            Iterator<Node> childNodes = node.getChildNodes();
            while (childNodes.hasNext()) {
                Node nextNode = childNodes.nextNode();
                if (nextNode instanceof Element) {
                    printNodes((Element) nextNode, indent + 1);
                } else if (nextNode instanceof Text) {
                    System.out.println("Element Text: " + nextNode.getNodeValue());
                }
            }
        }
    }
}