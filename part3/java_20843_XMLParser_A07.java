import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_20843_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("test.xml"));

            // Get all the 'item' elements in the XML file
            NodeList nodes = doc.getElementsByTagName("item");

            // Print the 'name' and 'description' of each 'item'
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                Element element = (Element) node;
                System.out.println("Name: " + element.getAttribute("name"));
                System.out.println("Description: " + element.getAttribute("description"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}