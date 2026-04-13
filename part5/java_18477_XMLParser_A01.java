import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_18477_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            System.out.println("Root element : " + doc.getDocumentElement().getNodeName());

            printNode(doc, doc.getDocumentElement());

            doc.getDocumentElement().normalize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printNode(Document doc, org.w3c.dom.Node node) {
        String prefix = "  ";
        String name = node.getNodeName();
        System.out.println(prefix + name);

        List children = node.getChildNodes();
        for (int i = 0; i < children.size(); i++) {
            Node child = (Node) children.item(i);
            printNode(doc, child);
        }
    }
}