import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileReader;

public class java_33332_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Step 1: Parse the XML file
            File xmlFile = new File("path_to_your_file.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // Step 2: Extract the data
            NodeList nodes = doc.getElementsByTagName("node");
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                System.out.println("Node " + (i + 1) + ": " + node.getTextContent());
            }

            // Step 3: Print out the data
            System.out.println("XML Parsing Completed.");

        } catch (Exception e) {
            System.out.println("Error in parsing the XML file: " + e);
        }
    }
}