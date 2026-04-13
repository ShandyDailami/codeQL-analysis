import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileReader;

public class java_07410_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Load the XML file
            File xmlFile = new File("path_to_your_xml_file.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Get all the elements in the XML file
            NodeList nodeList = doc.getElementsByTagName("*");

            // Print out the names and values of all the elements
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Element: " + element.getTagName());
                    System.out.println("Value: " + element.getFirstChild().getNodeValue());
                }
            }

            // Close the XML file
            doc.getDocumentElement().normalize();
            doc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}