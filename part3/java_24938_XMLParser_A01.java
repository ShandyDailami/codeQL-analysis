import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;

public class java_24938_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Create a new instance of the DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Create a new instance of the DocumentBuilder
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the XML file
            Document doc = dBuilder.parse(new File("path_to_your_xml_file.xml"));

            // Get the root element
            Element rootElement = doc.getDocumentElement();

            // Extract the value of the specific element
            NodeList nodes = rootElement.getElementsByTagName("element_name");
            for (int i = 0; i < nodes.getLength(); i++) {
                System.out.println("Element: " + nodes.item(i).getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}