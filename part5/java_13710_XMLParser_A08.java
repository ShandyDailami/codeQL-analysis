import java.util.List;
import java.util.stream.Collectors;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_13710_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Get the document builder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("your_file.xml"));

            // Get all the element names
            List<String> elementNames = getElementNames(doc);

            // Print the element names
            elementNames.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<String> getElementNames(Document doc) {
        NodeList nodes = doc.getElementsByTagName("*");
        return nodes.stream()
                .map(XmlParser::getElementName)
                .collect(Collectors.toList());
    }

    private static String getElementName(Node node) {
        if (node instanceof Element) {
            return node.getNodeName();
        }
        return null;
    }
}