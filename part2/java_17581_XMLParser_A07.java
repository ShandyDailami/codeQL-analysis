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
import java.io.FileOutputStream;

public class java_17581_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Step 1: Create a DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 2: Parse the XML file
            Document document = builder.parse(new File("input.xml"));

            // Step 3: Traverse the DOM tree
            NodeList nodeList = document.getElementsByTagName("note");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                System.out.println("Note " + (i + 1) + ": " + node.getTextContent());

                // Step 4: Print the XML structure
                printXml(document, node);

                // Step 5: Save the XML structure
                saveXml(document, node);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printXml(Document document, Node node) {
        System.out.println("\nNode: " + node.getNodeName() + " - " + node.getTextContent());
        if (node.getChildNodes().getLength() > 0) {
            for (int i = 0; i < node.getChildNodes().getLength(); i++) {
                printXml(document, node.getChildNodes().item(i));
            }
        }
    }

    private static void saveXml(Document document, Node node) {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new FileOutputStream("output.xml"));
        transformer.transform(source, result);
    }
}