import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.File;

public class java_21573_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a factory for building a document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use this factory to construct a document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the input file into a document
            Document doc = builder.parse(new File("input.xml"));

            // Find the root element of the document
            Element root = doc.getDocumentElement();

            // Get all the elements in the document
            NodeList elements = root.getChildNodes();

            // Iterate over the elements
            for (int i = 0; i < elements.getLength(); i++) {
                Element element = (Element) elements.item(i);

                // Print the name and value of the element
                System.out.println("Element: " + element.getNodeName());
                System.out.println("Value: " + element.getChildNodes().item(0).getNodeValue());
           
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}