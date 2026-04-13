import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_06025_XMLParser_A03 {

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("example.xml"));

            NodeList nodes = doc.getElementsByTagName("node");

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                Element element = (Element) node;

                String nodeName = element.getAttribute("name");
                String nodeValue = element.getAttribute("value");

                System.out.println("Node Name: " + nodeName);
                System.out.println("Node Value: " + nodeValue);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}