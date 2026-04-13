import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileReader;

public class java_02803_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("input.xml");
            FileReader reader = new FileReader(xmlFile);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            printElementAndAttributes(doc, null);

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElementAndAttributes(Document doc, Node node) {
        NodeList children = doc.getElementsByTagName(node == null ? "xml" : node.getNodeName());
        for (int i = 0; i < children.getLength(); ++i) {
            Node child = children.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                printElementAndAttributes(doc, child);
            } else if (child.getNodeType() == Node.ATTRIBUTE_NODE) {
                Element e = (Element) child;
                System.out.println("  @ " + e.getQName() + "='" + e.getAttributeNode("value").getValue() + "'");
            }
        }
    }
}