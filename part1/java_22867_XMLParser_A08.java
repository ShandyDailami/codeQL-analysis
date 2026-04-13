import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_22867_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Parse the XML file
            Document doc = builder.parse(new File("sample.xml"));

            // Get all the elements in the document
            NodeList nodes = doc.getElementsByTagName("student");

            // Iterate over all nodes
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                Element element = (Element) node;

                // Get the attributes and print them
                String name = element.getAttribute("name");
                String id = element.getAttribute("id");
                System.out.println("Name: " + name + ", ID: " + id);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}