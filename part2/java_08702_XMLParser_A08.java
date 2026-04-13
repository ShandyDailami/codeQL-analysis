import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_08702_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Create a factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use the factory to create a new document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document document = builder.parse(new File("sample.xml"));

            // Get all the elements
            NodeList nodeList = document.getElementsByTagName("element");

            // Process each element
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                Element element = (Element) node;
                String value = element.getTextContent();
                System.out.println("Element " + (i + 1) + ": " + value);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}