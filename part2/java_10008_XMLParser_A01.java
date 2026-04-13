import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_10008_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create DocumentBuilderFactory and DocumentBuilder instances
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse XML document
            Document doc = builder.parse(new File("sample.xml"));

            // Get all elements in the document
            NodeList nodes = doc.getElementsByTagName("note");

            // Loop through each note element
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                // Extract and print the note's content
                System.out.println("Content of note " + (i + 1) + " : "
                    + node.getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}