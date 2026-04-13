import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;

public class java_19601_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // parse the document
            Document document = builder.parse(new File("sample.xml"));

            // get the root element
            Element root = document.getDocumentElement();

            // print all element names and values
            printElements(root);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElements(Element element) {
        System.out.println("Element: " + element.getNodeName());

        // get all child elements
        List<Node> childNodes = new ArrayList<>(element.getChildNodes());
        for (Node child : childNodes) {
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                // cast the child node to an element
                Element childElement = (Element) child;
                // print the child element name and value
                printElements(childElement);
            } else if (child.getNodeType() == Node.TEXT_NODE) {
                System.out.println("Text: " + child.getNodeValue());
            }
        }
    }
}