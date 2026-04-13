import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_10912_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Create a factory for XML parsing
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("example.xml"));

            // Get the root element
            NodeList nList = doc.getElementsByTagName("person");

            // Iterate over all the elements in the list
            for (int temp = 0; temp < nList.getLength(); temp++) {
                // Get the current element
                Node nNode = nList.item(temp);

                // Extract the element data
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) nNode;

                    // Get the attributes
                    String firstName = e.getAttribute("firstName");
                    String lastName = e.getAttribute("lastName");

                    // Get the values
                    String id = e.getAttribute("id");

                    System.out.println("First Name: " + firstName);
                    System.out.println("Last Name: " + lastName);
                    System.out.println("ID: " + id);
                }
            }

            // Close the document
            doc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}