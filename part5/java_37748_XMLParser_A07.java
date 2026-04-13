import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_37748_XMLParser_A07 {

    public static void main(String[] args) {

        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            // Print document elements
            printDocument(doc);

        } catch (IOException e) {
            e.printStackTrace();
        // Handle I/O Exception
        } catch (SAXException e) {
            e.printStackTrace();
        // Handle SAX Exception
        }
    }

    // Print document elements
    private static void printDocument(Document doc) {
        // print node and its attributes
        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
        System.out.println("-----------------");
        printNode(doc.getDocumentElement(), 0);
    }

    // Recursive function to print the XML tree
    private static void printNode(org.w3c.dom.Node node, int indent) {
        // print node name and its attributes
        System.out.print(getSpaces(indent));
        System.out.println(node.getNodeName());

        // if node has attributes, print them
        if (node.hasAttributes()) {
            System.out.print(getSpaces(indent));
            System.out.println("Attributes: ");
            for (int i = 0; i < node.getAttributes().getLength(); i++) {
                org.w3c.dom.Attr attr = node.getAttributes().item(i);
                System.out.print(getSpaces(indent));
                System.out.print(attr.getName() + " = " + attr.getValue());
                if (i < node.getAttributes().getLength() - 1) {
                    System.out.print(", ");
                }
            }
        }

        // print child nodes
        if (node.hasChildNodes()) {
            System.out.print(getSpaces(indent));
            System.out.println("Children: ");
            for (int i = 0; i < node.getChildNodes().getLength(); i++) {
                org.w3c.dom.Node childNode = node.getChildNodes().item(i);
                printNode(childNode, indent + 1);
            }
        }
    }

    // Returns the appropriate indentation string for the given indent level
    private static String getSpaces(int indent) {
        StringBuilder spaces = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            spaces.append(" ");
        }
        return spaces.toString();
    }
}