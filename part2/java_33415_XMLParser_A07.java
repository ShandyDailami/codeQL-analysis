import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_33415_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Create DocumentBuilderFactory and get a new instance
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file and load it into a Document object
            Document document = builder.parse(new File("test.xml"));

            // Get the root element
            NodeList nodeList = document.getElementsByTagName("student");

            // Iterate through each node
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                // Get the node type and name
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    String id = element.getElementsByTagName("id").item(0).getTextContent();

                    System.out.println("Name: " + name);
                    System.out.println("ID: " + id);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}