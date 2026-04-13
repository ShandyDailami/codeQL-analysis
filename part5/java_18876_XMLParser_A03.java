import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_18876_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("sample.xml"));

            // Get all the nodes
            NodeList nodes = doc.getElementsByTagName("student");

            // Iterate over all the nodes
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                Element element = (Element) node;

                // Get the student's name and score
                String name = element.getElementsByTagName("name").item(0).getTextContent();
                String score = element.getElementsByTagName("score").item(0).getTextContent();

                System.out.println("Name: " + name);
                System.out.println("Score: " + score);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}