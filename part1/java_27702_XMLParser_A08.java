import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_27702_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Step 2: Use the factory to create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Parse the XML file
            Document document = builder.parse(new File("path_to_your_xml_file.xml"));

            // Step 4: Get the document root element
            Element root = document.getDocumentElement();

            // Step 5: Print out the names and values of each element
            printElement(root);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElement(Element element) {
        System.out.println("Element Name: " + element.getNodeName());
        System.out.println("Element Value: " + element.getNodeValue());

        // Step 6: Recursively print out the names and values of each child element
        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            printElement((Element) children.item(i));
        }
    }
}