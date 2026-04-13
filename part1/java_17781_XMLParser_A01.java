import java.io.File;
import java.util.Iterator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URI;

public class java_17781_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Get the XML document
            File inputFile = new File("src/input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            // Get the root element
            doc.getDocumentElement().normalize();
            System.out.println("Root Element : " + doc.getDocumentElement().getNodeName());

            // Find all elements
            NodeList nList = doc.getElementsByTagName("*");

            // Iterate through all the elements
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                // Print all the elements and their attributes
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Element : " + eElement.getTagName());

                    // Print all attributes
                    Iterator<Node> attributeIterator = eElement.attributes().iterator();
                    while (attributeIterator.hasNext()) {
                        Node attribute = attributeIterator.next();
                        System.out.println("Attribute : " + attribute.getNodeName() + "= '" + attribute.getNodeValue() + "'");
                    }
                }
            }

            dBuilder = null;
            dbFactory = null;
            doc = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}