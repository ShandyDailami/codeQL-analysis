import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.List;
import java.util.ArrayList;

public class java_12998_XMLParser_A01 {

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false); // Disable validation for simplicity
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(new File("input.xml")); // Load XML file
            document.getDocumentElement().normalize();

            NodeList nodes = document.getElementsByTagName("element");
            List<String> data = new ArrayList<>();

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                data.add(node.getTextContent()); // Extract data from specific elements
            }

            // Print extracted data
            for (String str : data) {
                System.out.println(str);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}