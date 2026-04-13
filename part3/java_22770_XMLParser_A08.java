import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_22770_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root Element : " + doc.getDocumentElement().getNodeName());
            printElement(doc.getDocumentElement());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElement(Element elem) {
        System.out.println("Element : " + elem.getNodeName());
        NodeList children = elem.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            if (node.getNodeType() == Node.TEXT_NODE)
                continue;
            System.out.println("Child Node : " + node.getNodeName() + " : " + node.getNodeValue());
            printElement((Element) node);
        }
    }
}