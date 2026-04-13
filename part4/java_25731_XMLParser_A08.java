import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_25731_XMLParser_A08 {
    public static void main(String[] args) {
        // Create a DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("sample.xml"));

            // Get the root element
            doc.getDocumentElement().normalize();

            // Get the list of all child nodes
            NodeList nodeList = doc.getElementsByTagName("student");

            // Iterate over the list of students
            for (int i = 0; i < nodeList.getLength(); i++) {
                // Get the current node
                Node node = nodeList.item(i);

                // Print the information of the current student
                System.out.println("Student " + (i + 1));
                System.out.println("Name: " + node.getFirstChild().getNodeValue());
                System.out.println("Age: " + node.getNextSibling().getNodeValue());
                System.out.println("Grade: " + node.getNextSibling().getNextSibling().getNodeValue());
                System.out.println("-----------------------------------------");
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}