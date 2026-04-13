import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.IOException;

public class java_41775_XMLParser_A03 {
    public static void main(String[] args) {
        //Step 1: Create an instance of DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        //Step 2: Use factory to get a document builder
        DocumentBuilder builder = factory.newDocumentBuilder();

        //Step 3: Use builder to parse the input XML file
        Document doc = null;
        try {
            doc = builder.parse("injection.xml"); //replace with your file path
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Step 4: Retrieve the document's elements
        NodeList nodes = doc.getElementsByTagName("student");

        //Step 5: Iterate over the nodes to extract the required data
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            String id = node.getAttributes().getNamedItem("id").getNodeValue();
            String name = node.getAttributes().getNamedItem("name").getNodeValue();
            String course = node.getAttributes().getNamedItem("course").getNodeValue();
            String grade = node.getAttributes().getNamedItem("grade").getNodeValue();

            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Course: " + course);
            System.out.println("Grade: " + grade);
        }
    }
}