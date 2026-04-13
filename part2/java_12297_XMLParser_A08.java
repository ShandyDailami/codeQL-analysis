import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_12297_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Create a factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            // Use the factory to get a builder
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Parse the XML file
            Document doc = builder.parse(new File("input.xml"));
            
            // Get the root element
            NodeList nodes = doc.getElementsByTagName("employee");
            
            // Iterate over each employee
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                Element employee = (Element) node;
                
                // Extract and print the data
                String name = employee.getElementsByTagName("name").item(0).getTextContent();
                String age = employee.getElementsByTagName("age").item(0).getTextContent();
                String position = employee.getElementsByTagName("position").item(0).getTextContent();
                
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Position: " + position);
                System.out.println("--------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}