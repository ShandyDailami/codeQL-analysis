import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;

public class java_24911_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a factory for reading from the DOM
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Read the XML file
            Document doc = builder.parse(new File("sample.xml"));

            // Get the root element
            Element root = doc.getDocumentElement();

            // Get all the element nodes
            NodeList nodes = root.getChildNodes();

            // Print out the names and values of all the elements
            for (int i = 0; i < nodes.getLength(); i++) {
                Element e = (Element) nodes.item(i);
                System.out.println("Element: " + e.getNodeName());
                System.out.println("Value: " + e.getFirstChild().getNodeValue());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}