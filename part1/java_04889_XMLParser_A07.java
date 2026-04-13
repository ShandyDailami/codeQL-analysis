import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class java_04889_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a DocumentBuilderFactory and a Document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("input.xml"); // input file is assumed to be in the same directory

            // Step 2: Retrieve the root element
            Node root = doc.getDocumentElement();

            // Step 3: Traverse the XML file and print out the name and value of each element
            printElements(root);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElements(Node node) {
        if (node.hasChildNodes()) {
            for (Node child = node.getFirstChild(); child != null; child = child.getNextSibling()) {
                if (child.getNodeType() == Node.ELEMENT_NODE) {
                    printElements(child);
                } else if (child.getNodeType() == Node.TEXT_NODE && ((Text) child).getText().trim().length() > 0) {
                    System.out.println("  " + child.getNodeValue());
                }
            }
        }
    }
}