import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_16510_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Create a factory object
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the input XML file
            Document doc = builder.parse(new File("sample.xml"));

            // Get the document elements
            NodeList nList = doc.getElementsByTagName("student");

            // Print out the elements
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nStudent Details: " + temp);

                Element eElement = (Element) nNode;

                // Print out the student details
                System.out.println("Name: " + eElement.getElementsByTagName("name").item(0).getTextContent());
                System.out.println("Age: " + eElement.getElementsByTagName("age").item(0).getTextContent());
                System.out.println("Country: " + eElement.getElementsByTagName("country").item(0).getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}