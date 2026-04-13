import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_05075_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root Element : " + doc.getElementsByTagName("element").item(0).getTextContent());

            List<String> elementValues = getElementValues(doc, "element");
            System.out.println("Element values : " + elementValues);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<String> getElementValues(Document doc, String elementName) {
        // Use XPath to select nodes
        String xpath = String.format("/element/text()");
        List<String> values = null; // Use a list to store the values

        try {
            NodeList nodes = doc.selectNodes(xpath);
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                values.add(node.getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return values;
    }
}