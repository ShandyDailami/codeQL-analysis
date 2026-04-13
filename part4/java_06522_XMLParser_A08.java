import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class java_06522_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory and use it to create a new DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the input file into a Document object
            Document doc = builder.parse(new File("input.xml"));

            // Get the root element of the Document
            Element root = doc.getDocumentElement();

            // Print out the names and values of the elements
            printElements(root);

            // Print out the modified XML file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(Transformer.OUTPUT_ENCODING, "UTF-8");
            transformer.transform(new DOMSource(doc), new StreamResult(System.out));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElements(Element element) {
        // Print the name and value of the current element
        System.out.println("Name: " + element.getNodeName());
        System.out.println("Value: " + element.getChildNodes().item(0).getNodeValue());

        // Get the list of child elements
        NodeList children = element.getChildNodes();

        // Recursively call printElements for each child element
        for (int i = 0; i < children.getLength(); i++) {
            printElements((Element) children.item(i));
        }
    }
}