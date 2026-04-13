import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.transform.Transformer;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class java_28944_XMLParser_A03 {
    public static void main(String[] args) {
        // Create a DocumentBuilderFactory and use it to create a Document
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            // Parse the XML file
            Document doc = builder.parse(new File("input.xml"));

            // Normalize the document
            doc.getDocumentElement().normalize();

            // Print all element names
            printElementNames(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElementNames(Document doc) {
        // Get all element names
        NodeList nodeList = doc.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            System.out.println("Element: " + element.getTagName());
        }
    }
}