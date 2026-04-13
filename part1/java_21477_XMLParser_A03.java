import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;

public class java_21477_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Create a new DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use the factory to create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Use the builder to parse the XML file
            Document doc = builder.parse(new File("input.xml"));

            // Get all the elements in the document
            NodeList nodeList = doc.getElementsByTagName("*");

            // Loop through all the elements
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                // Get the value of the current element
                String value = element.getFirstChild().getNodeValue();
                // Print the value
                System.out.println("Value of tag " + element.getTagName() + " is: " + value);
           
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}