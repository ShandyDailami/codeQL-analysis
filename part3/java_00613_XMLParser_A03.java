import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_00613_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Parse the XML file
            Document doc = builder.parse(new File("sample.xml"));
            
            // Get all the elements in the document
            NodeList nodes = doc.getElementsByTagName("employee");
            
            // Loop through each employee element
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                Element element = (Element) node;
                
                // Print out information for each employee
                System.out.println("Employee ID: " + element.getAttribute("id"));
                System.out.println("Employee Name: " + element.getAttribute("name"));
                System.out.println("Employee Role: " + element.getAttribute("role"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}