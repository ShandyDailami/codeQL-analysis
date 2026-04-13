import java.util.List;
import java.util.stream.Collectors;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_13626_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("input.xml"));
            doc.getDocumentElement().normalize();

            // Extract data from XML file
            List<String> data = extractData(doc);

            // Print out data
            for (String s : data) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<String> extractData(Document doc) {
        NodeList nodeList = doc.getElementsByTagName("*");
        return nodeList.stream()
                .map(XMLParser::extractDataNode)
                .collect(Collectors.toList());
    }

    private static String extractDataNode(Node node) {
        if (node instanceof Element) {
            return node.getNodeName();
        }
        return "";
    }
}