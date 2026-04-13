import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_00513_XMLParser_A07 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            // Create a new document
            Document doc = builder.parse(new File("example.xml"));

            // Get all 'name' tags
            NodeList nodes = doc.getElementsByTagName("name");

            // Print out the content of 'name' tags
            for (int i = 0; i < nodes.getLength(); i++) {
                System.out.println("Name #" + (i + 1) + ": " + nodes.item(i).getTextContent());
            }

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}