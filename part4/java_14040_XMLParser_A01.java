import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class java_14040_XMLParser_A01 {
    public static void main(String[] args) {
        // Create a factory for handling DOM
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // Create a new document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the input file into a DOM document
            Document doc = builder.parse(new File("input.xml"));

            // Normalize the document to ensure elements and attributes are in
            // correct order, Repeat with proper indenting so it looks nice
            doc.getDomConfig().setValidate(true);
            doc.write(System.out);

            // Retrieve root element
            Element root = doc.getDocumentElement();

            // Get all elements with the tag name "element"
            NodeList list = doc.getElementsByTagName("element");

            // Loop through each element
            for (int i = 0; i < list.getLength(); i++) {
                Element element = (Element) list.item(i);

                // Get the attribute value
                String attributeValue = element.getAttribute("attribute");

                // Print out the attribute value
                System.out.println("Attribute value: " + attributeValue);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}