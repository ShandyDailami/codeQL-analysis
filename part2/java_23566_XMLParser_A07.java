import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_23566_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Load the XML file
            File xmlFile = new File("path_to_your_xml_file.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // Print out each element and its attributes
            printElements(doc, null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElements(Document doc, String prefix) {
        NodeList nodes = doc.getElementsByTagName("*");
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.print(prefix + element.getTagName());
                printElements(doc, element.getPrefix());
                System.out.println(": " + element.getAttribute("name"));
            }
        }
    }
}