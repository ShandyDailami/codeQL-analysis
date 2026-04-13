import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_12525_XMLParser_A01 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(inputFile);

            // Retrieve the root element of the document
            Element rootElement = doc.getDocumentElement();

            // Retrieve the list of elements with the same name
            List<Element> elements = getElementsByTagName(rootElement, "element");

            // Print the content of the first element
            printElementContent(elements.get(0));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<Element> getElementsByTagName(Element element, String tagName) {
        // Find all elements with the same name
        NodeList nodeList = element.getElementsByTagName(tagName);

        // Create a list to store the elements
        List<Element> elements = null;

        // Iterate over the list of elements
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element node = (Element) nodeList.item(i);
            elements.add(node);
        }

        return elements;
    }

    private static void printElementContent(Element element) {
        // Print the content of the element
        System.out.println("Content: " + element.getTextContent());
    }
}