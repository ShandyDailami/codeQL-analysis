import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.net.URL;

public class java_18483_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Load the XML document
            URL url = new File("example.xml").toURI().toURL();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(url.openStream());
            doc.getDocumentElement().normalize();

            // Find and print all 'item' elements
            NodeList nodes = doc.getElementsByTagName("item");
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Item " + (i + 1) + ": " + element.getAttribute("id"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}