import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_40216_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Create a new DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("sample.xml"));

            // Get the root element
            Element root = doc.getDocumentElement();

            // Get all child nodes of the root element
            NodeList children = root.getChildNodes();

            // Print out the name and value of each child node
            for (int i = 0; i < children.getLength(); i++) {
                Node child = children.item(i);
                if (child.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) child;
                    System.out.println("Name: " + element.getNodeName());
                    System.out.println("Value: " + element.getChildNodes().item(0).getTextContent());
                }
           
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}