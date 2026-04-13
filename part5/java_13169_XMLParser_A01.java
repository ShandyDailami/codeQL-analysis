import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_13169_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder using the factory
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the XML file
            Document doc = dBuilder.parse(new File("input.xml"));

            // Get the root element
            doc.getDocumentElement().normalize();

            // Get all child elements
            NodeList nList = doc.getElementsByTagName("*");

            // Print out the name and value of each element
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Element n = (Element) nList.item(temp);
                System.out.println("Element : " + n.getNodeName() + "  Value : " + n.getTextContent());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}