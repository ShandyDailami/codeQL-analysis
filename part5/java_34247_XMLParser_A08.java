import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_34247_XMLParser_A08 {
    public static void main(String[] args) {
        // Step 1: Create a DocumentBuilderFactory and use it to create a Document
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            // Step 2: Parse the XML file and use the builder to build a document from the file
            Document document = builder.parse(new File("input.xml"));

            // Step 3: Use the document to get the root element and print its name
            Element root = document.getDocumentElement();
            System.out.println("Root element: " + root.getNodeName());

            // Step 4: Use a recursive method to extract all 'item' elements and print their content
            extractItems(root);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void extractItems(Element element) {
        List<Node> itemElements = element.getElementsByTagName("item");
        for (int i = 0; i < itemElements.size(); i++) {
            Node itemNode = itemElements.get(i);
            if (itemNode instanceof Element) {
                Element itemElement = (Element) itemNode;
                System.out.println("Item " + (i + 1) + ": " + itemElement.getAttribute("name"));
                // Recursive call to extract items from the sub-elements
                extractItems(itemElement);
            }
        }
    }
}