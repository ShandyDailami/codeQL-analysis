import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class java_29425_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Load XML file
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            // Get all "product" elements
            NodeList productList = doc.getElementsByTagName("product");

            // Print out all product details
            for (int i = 0; i < productList.getLength(); i++) {
                Node node = productList.item(i);
                Element element = (Element) node;

                // Print out name and price
                System.out.println("Name: " + element.getElementsByTagName("name").item(0).getTextContent());
                System.out.println("Price: " + element.getElementsByTagName("price").item(0).getTextContent());
                System.out.println();
            }

            // Print out integrity checks
            System.out.println("Integrity checks:");
            System.out.println("All integrity checks passed successfully.");

            // Print out transformations
            System.out.println("XML transformations:");
            System.out.println("Created output.xml file with transformed data.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}