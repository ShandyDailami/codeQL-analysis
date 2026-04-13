import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.net.URI;

public class java_22130_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Load XML document from file
            File inputFile = new File("input.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(inputFile);

            // Process the document (e.g., print all elements)
            NodeList nodeList = doc.getElementsByTagName("*");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Element: " + element.getTagName());
                }
            }

            // Print a message to the standard output
            System.out.println("XML Parsing and Processing Completed.");

        } catch (Exception e) {
            System.out.println("An error occurred while parsing the XML file.");
            e.printStackTrace();
        }
    }
}