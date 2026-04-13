import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;

public class java_18716_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("sample.xml"));

            // Get all the elements in the document
            NodeList nodes = doc.getElementsByTagName("node");

            // Create a map to store the data
            Map<String, String> map = new HashMap<>();

            // Iterate over all the nodes
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);

                // Extract the data
                Element element = (Element) node;
                String name = element.getAttribute("name");
                String value = element.getAttribute("value");

                // Store the data in the map
                map.put(name, value);
            }

            // Print the data
            for (Map.Entry<String, String> entry : map.entrySet()) {
                System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}