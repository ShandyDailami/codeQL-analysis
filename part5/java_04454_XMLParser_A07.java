import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_04454_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a new instance of the DocumentBuilder
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the input XML file and store it in a Document object
            Document doc = dBuilder.parse(new File("input.xml"));

            // Print out the content of the XML file
            System.out.println("XML File Content: ");
            doc.getElementsByTagName("*").item(0).getFirstChild().normalize();
            printElement(doc.getElementsByTagName("*").item(0));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElement(org.w3c.dom.Node node) {
        if (node.hasChildNodes()) {
            for (int i = 0; i < node.getChildNodes().getLength(); i++) {
                printElement(node.getChildNodes().item(i));
            }
        } else {
            System.out.println(node.getNodeName() + " : " + node.getTextContent());
        }
    }
}