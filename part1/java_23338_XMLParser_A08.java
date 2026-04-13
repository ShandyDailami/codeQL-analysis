import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;

public class java_23338_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a new instance of the DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a new instance of the DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("input.xml"));

            // Normalize the document
            doc.normalize();

            // Get the root element of the document
            Element root = doc.getDocumentElement();

            // Get all the elements in the document
            NodeList nodes = root.getChildNodes();

            // Iterate over the nodes
            Iterator<Node> iterator = nodes.iterator();
            while (iterator.hasNext()) {
                Node node = iterator.next();

                // Check if the node is an element
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    // Get the element name
                    String name = element.getNodeName();

                    // Get the element attributes
                    if (element.hasAttributes()) {
                        Iterator<org.w3c.dom.Attr> attrIterator = element.attributes().iterator();
                        while (attrIterator.hasNext()) {
                            org.w3c.dom.Attr attr = attrIterator.next();
                            System.out.println("Attribute: " + attr.getName() + ", Value: " + attr.getValue());
                        }
                    }

                    // Print the element name
                    System.out.println("Element: " + name);

                    // Get the element children
                    NodeList childNodes = element.getChildNodes();
                    Iterator<Node> childNodeIterator = childNodes.iterator();
                    while (childNodeIterator.hasNext()) {
                        Node childNode = childNodeIterator.next();
                        if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element childElement = (Element) childNode;
                            System.out.println("Child element: " + childElement.getNodeName());
                        }
                    }
                }
            }

            // Calculate the MD5 hash of the XML file
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(doc.toString().getBytes());
            byte[] digest = md.digest();
            StringBuilder hash = new StringBuilder();
            for (byte b : digest) {
                hash.append(String.format("%02x", b & 0xff));
            }
            System.out.println("MD5 Hash: " + hash.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}