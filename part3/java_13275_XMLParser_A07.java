import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.Iterator;

public class java_13275_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Load XML file
            FileInputStream fis = new FileInputStream("sample.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fis);
            doc.getDocumentElement().normalize();

            // Print out elements
            printElements(doc);

            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printElements(Document doc) {
        NodeList nList = doc.getElementsByTagName("*");
        Iterator<Node> nodeIterator = nList.iterator();

        while (nodeIterator.hasNext()) {
            Node node = nodeIterator.next();

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Element name: " + element.getNodeName());
                System.out.println("Element value: " + element.getTextContent());
            }
        }
    }
}