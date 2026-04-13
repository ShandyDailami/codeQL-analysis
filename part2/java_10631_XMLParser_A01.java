import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_10631_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            
            // Create a DocumentBuilder using the factory
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the document using the builder
            Document doc = dBuilder.parse(new File("input.xml"));

            // Get the root element of the document
            doc.getDocumentElement().normalize();

            // Print all the element nodes
            printElements(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElements(Document doc) {
        NodeList nl = doc.getElementsByTagName("*");
        for (int i = 0; i < nl.getLength(); i++) {
            Node n = nl.item(i);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) n;
                String elementName = e.getTagName();
                System.out.println("Element Name: " + elementName);
            }
        }
    }
}