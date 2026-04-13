import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_39544_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Load the XML file
            File xmlFile = new File("path_to_your_file.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // Get the root element
            Element root = doc.getDocumentElement();

            // Print out the content of each element
            printElementContent(root);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElementContent(Node node) {
        if (node instanceof Element) {
            Element element = (Element) node;
            System.out.println("Element: " + element.getNodeName());
            printElementContent(element);
        } else if (node instanceof Text) {
            Text text = (Text) node;
            System.out.println("Text: " + text.getNodeValue());
        }
    }
}