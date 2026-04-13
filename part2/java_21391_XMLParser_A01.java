import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.File;

public class java_21391_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Get a factory for document builder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use the factory to create a document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Use the builder to parse the file
            Document doc = builder.parse(new File("path_to_your_xml_file.xml"));

            // Get all the elements in the document
            NodeList nodeList = doc.getElementsByTagName("*");

            // Process each element
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);

                // Print the element name
                System.out.println("Element: " + element.getTagName());

                // Print the element attributes
                for (int j = 0; j < element.getAttributes().getLength(); j++) {
                    System.out.println("Attribute: " + element.getAttributes().item(j).getNodeName() + " = " + element.getAttributes().item(j).getTextContent());
                }
           
                // Print the element content
                System.out.println("Content: " + element.getTextContent());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}