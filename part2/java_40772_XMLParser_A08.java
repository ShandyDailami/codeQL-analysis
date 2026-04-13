import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_40772_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Step 1: Setup the DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 2: Parse the XML file
            Document doc = builder.parse(new File("input.xml"));

            // Step 3: Extract the data
            NodeList nodes = doc.getElementsByTagName("element");
            for(int i=0; i<nodes.getLength(); i++) {
                Node node = nodes.item(i);
                System.out.println("Child Node: " + node.getNodeName());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}