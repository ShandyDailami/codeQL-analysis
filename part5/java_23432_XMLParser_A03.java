import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_23432_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create DocumentBuilderFactory and Document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("sample.xml"));

            // Get all the 'item' nodes in the document
            NodeList items = doc.getElementsByTagName("item");

            // Loop over each 'item' node
            for (int i = 0; i < items.getLength(); i++) {
                Node node = items.item(i);
                if (node instanceof Element) {
                    Element item = (Element) node;

                    // Get and print the value of the 'name' attribute
                    String name = item.getAttribute("name");
                    System.out.println("Name: " + name);

                    // Get and print the value of the 'price' attribute
                    String price = item.getAttribute("price");
                    System.out.println("Price: " + price);

                    // Get and print the value of the 'description' element
                    String description = item.getAttribute("description");
                    System.out.println("Description: " + description);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}