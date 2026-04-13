import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileReader;

public class java_34792_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File file = new File("sample.xml");
            FileReader reader = new FileReader(file);

            // Step 1: Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Step 2: Use the factory to create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Parse the XML file into a Document object
            Document doc = builder.parse(file);

            // Step 4: Get all the elements in the document
            NodeList nodes = doc.getElementsByTagName("student");

            // Step 5: Iterate over all the elements
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);

                // Step 6: Get the element's attributes
                Element element = (Element) node;

                // Step 7: Print out the attribute values
                String name = element.getAttribute("name");
                String id = element.getAttribute("id");
                System.out.println("Name: " + name + ", ID: " + id);
            }

            // Close the reader and document
            reader.close();
            doc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}