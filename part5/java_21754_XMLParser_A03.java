import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.lang.Exception;

public class java_21754_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            InputStream input = new FileInputStream(inputFile);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(input);
            doc.getDocumentElement().normalize();

            System.out.println("Root Element : " + doc.getDocumentElement().getNodeName());

            printNodes(doc, doc.getDocumentElement());

            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printNodes(Document doc, Element elem) {
        List<Node> childNodes = doc.getChildNodes();

        for (int i = 0; i < childNodes.size(); i++) {
            Node node = childNodes.get(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                printNodes(doc, element);
                System.out.println("Node Name : " + element.getNodeName());
            }
        }
    }
}