import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class java_31691_XMLParser_A07 {
    public static void main(String[] args) {
        // Create a DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the input file and store it in a Document object
            Document doc = builder.parse(new File("input.xml"));

            // Normalize the document to ensure that the XML is valid
            doc.normalize();

            // Print all element names and their corresponding text
            printElementNamesAndText(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElementNamesAndText(Document doc) {
        Element root = doc.getDocumentElement();
        System.out.println("Root Element: " + root.getNodeName());

        // Print all element names and their corresponding text
        printElementNamesAndText(root);
    }

    private static void printElementNamesAndText(Element element) {
        System.out.println("Element: " + element.getNodeName());

        // If the element is a text node, print its text
        if (element.hasChildNodes()) {
            for (int i = 0; i < element.getChildNodes().getLength(); i++) {
                Node node = element.getChildNodes().item(i);
                if (node.getNodeType() == Node.TEXT_NODE) {
                    System.out.println("Text: " + node.getTextContent());
                }
            }
        }

        // Recursive call to print the child elements
        for (int i = 0; i < element.getChildNodes().getLength(); i++) {
            Node node = element.getChildNodes().item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                printElementNamesAndText((Element) node);
            }
        }
    }
}