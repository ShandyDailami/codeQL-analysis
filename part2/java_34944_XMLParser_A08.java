import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class java_34944_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("example.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            // Retrieve root element
            Element rootElement = document.getDocumentElement();

            // Print the name of all elements
            printElements(rootElement);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElements(Element element) {
        // print element name
        System.out.println(element.getNodeName());

        // print attributes
        if (element.hasAttributes()) {
            NodeList attributes = element.getAttributes();
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.println(attributes.item(i).getNodeName() + " = "
                        + attributes.item(i).getTextContent());
            }
        }

        // print children
        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            printElements((Element) children.item(i));
        }
    }
}