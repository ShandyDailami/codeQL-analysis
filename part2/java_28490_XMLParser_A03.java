import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.net.URL;

public class java_28490_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            URL url = new File("path_to_your_file.xml").toURI().toURL();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(url.openStream());

            doc.getDocumentElement().normalize();
            NodeList nodes = doc.getElementsByTagName("tag_name");

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    // Here you can handle the data from XML nodes.
                    System.out.println("Data: " + element.getTextContent());
                }
            }

            doc.detachNode(node);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}