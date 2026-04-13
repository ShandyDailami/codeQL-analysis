import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_32107_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Step 1: Create DocumentBuilderFactory and Document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("example.xml"));

            // Step 2: Get all 'item' elements
            NodeList items = doc.getElementsByTagName("item");

            // Step 3: Iterate over each 'item' element
            for (int i = 0; i < items.getLength(); i++) {
                Element item = (Element) items.item(i);

                // Step 4: Extract the 'name' and 'quantity' attributes from each 'item' element
                String name = item.getAttribute("name");
                String quantity = item.getAttribute("quantity");

                // Step 5: Print the extracted attributes
                System.out.println("Item: " + name);
                System.out.println("Quantity: " + quantity);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}