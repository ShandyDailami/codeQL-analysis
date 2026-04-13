import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileReader;

public class java_22939_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml"); // replace with your xml file
            FileReader reader = new FileReader(xmlFile);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // Get all the nodes in the document
            NodeList nodes = doc.getElementsByTagName("*");

            // Print out the names of all the elements
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Element: " + element.getTagName());
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}