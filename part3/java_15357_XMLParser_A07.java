import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_15357_XMLParser_A07 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            printElements(doc);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printElements(Document doc) {
        NodeList nlist = doc.getElementsByTagName("*");
        for (int temp = 0; temp < nlist.getLength(); temp++) {
            Node node = nlist.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;
                System.out.println("Element name: " + elem.getNodeName());
                Iterator<Node> children = elem.getChildNodes().iterator();
                while (children.hasNext()) {
                    Node child = children.nextNode();
                    if (child.getNodeType() == Node.ELEMENT_NODE) {
                        System.out.println("Child element name: " + child.getNodeName());
                    }
                }
            }
        }
    }
}