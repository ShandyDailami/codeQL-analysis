import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_12266_XMLParser_A07 {
    public static void main(String[] args) {
        // Load the XML document
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("path_to_your_file.xml"));

        // Get all 'person' elements
        NodeList persons = doc.getElementsByTagName("person");

        // Loop through each 'person' element
        for (int i = 0; i < persons.getLength(); i++) {
            Node personNode = persons.item(i);

            // Get the 'name' and 'age' attributes of the current 'person' element
            Element personElement = (Element) personNode;
            String name = personElement.getAttribute("name");
            String age = personElement.getAttribute("age");

            System.out.println("Person " + (i + 1) + ": Name = " + name + ", Age = " + age);
        }
    }
}