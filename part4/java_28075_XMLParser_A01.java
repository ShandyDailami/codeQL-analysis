import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_28075_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("example.xml"));

            // Get the root element
            Node root = doc.getDocumentElement();

            // Get the list of names
            List<String> names = getNodeNames(root);

            // Print the names
            for (String name : names) {
                System.out.println(name);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<String> getNodeNames(Node node) {
        List<String> names = new ArrayList<>();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            names.add(node.getNodeName());
            for (Node child = node.getFirstChild(); child != null; child = child.getNextSibling()) {
                names.addAll(getNodeNames(child));
            }
        }
        return names;
    }
}