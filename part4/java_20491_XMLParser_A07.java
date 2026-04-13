import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_20491_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 2: Parse the XML document
            Document doc = builder.parse(new File("sample.xml"));

            // Step 3: Extract the text of the elements
            NodeList nodes = doc.getElementsByTagName("element");
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String text = element.getTextContent();
                    System.out.println("Text content of element " + i + ": " + text);
                }
            }

            // Close the Document
            doc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}