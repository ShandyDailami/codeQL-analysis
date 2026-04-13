import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.File;
import java.io.IOException;

public class java_29416_XMLParser_A07 {
    public static void main(String[] args) {
        // Load the XML file
        File xmlFile = new File("path/to/your/file.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = builder.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Get the root element
        Element root = doc.getDocumentElement();

        // Get all child elements
        NodeList children = root.getChildNodes();

        // Print the names of the child elements
        for (int i = 0; i < children.getLength(); i++) {
            Element child = (Element) children.item(i);
            System.out.println("Child element: " + child.getNodeName());
        }
    }
}