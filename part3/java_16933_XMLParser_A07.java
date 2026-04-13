import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.net.URL;

public class java_16933_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Load the XML document
            URL url = new URL("https://example.com/sample.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(url.openStream());

            // Get all the elements in the document
            NodeList nodeList = doc.getElementsByTagName("*");

            // Loop through all elements
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    System.out.println("Element: " + node.getNodeName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}