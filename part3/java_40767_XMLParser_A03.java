import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;

public class java_40767_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Parse the XML file
            Document doc = builder.parse(new File("sample.xml"));
            // Get all the elements
            NodeList nodes = doc.getElementsByTagName("student");
            // Print all the elements
            for (int i = 0; i < nodes.getLength(); i++) {
                System.out.println("Student " + (i + 1) + ": " + nodes.item(i).getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}