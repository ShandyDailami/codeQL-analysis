import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;

public class java_17388_XMLParser_A01 {

    public static void main(String[] args) {
        // Create a DocumentBuilderFactory and DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parse the XML file
        Document document = builder.parse(new File("path/to/your/file.xml"));

        // Get all the elements
        NodeList nodes = document.getElementsByTagName("tag");

        // Process the elements
        for (int i = 0; i < nodes.getLength(); i++) {
            Element element = (Element) nodes.item(i);

            // Do something with the element
            String elementContent = element.getTextContent();
            System.out.println("Content of element " + (i + 1) + ": " + elementContent);
        }
    }
}