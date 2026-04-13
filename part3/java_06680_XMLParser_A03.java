import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class java_06680_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Step 2: Use the factory to create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Parse the XML file
            Document document = builder.parse(new File("path_to_your_xml_file.xml"));

            // Step 4: Get all the 'name' elements
            NodeList nodeList = document.getElementsByTagName("name");

            // Step 5: Iterate over the 'name' elements and print their content
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                System.out.println("Name " + (i + 1) + ": " + element.getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}