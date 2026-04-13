import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class java_29557_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a factory for building a document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the document
            Document doc = builder.parse(new File("sample.xml"));

            // Normalize the document
            doc.getDocumentElement().normalize();

            // Print the document elements
            printElements(doc.getElementsByTagName("student"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElements(NodeList nodes) {
        for (int i = 0; i < nodes.getLength(); i++) {
            printElement((Element) nodes.item(i));
        }
    }

    private static void printElement(Element element) {
        System.out.println("Name: " + element.getElementsByTagName("name").item(0).getTextContent());
        System.out.println("Age: " + element.getElementsByTagName("age").item(0).getTextContent());
    }
}