import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class java_24772_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // Print out the XML document elements
            printDocument(doc);

            // Transform the XML document
            transformDocument(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printDocument(Document doc) {
        Element root = doc.getDocumentElement();
        System.out.println("Root element: " + root.getNodeName());

        NodeList children = root.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            if (node.getNodeType() == Node.TEXT_NODE) {
                System.out.println("Text node: " + node.getNodeValue());
            } else {
                System.out.println("Element node: " + node.getNodeName());
            }
        }
    }

    private static void transformDocument(Document doc) {
        Element root = doc.getDocumentElement();
        System.out.println("Transformed root element: " + root.getNodeName());

        NodeList children = root.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            if (node.getNodeType() == Node.TEXT_NODE) {
                System.out.println("Transformed text node: " + node.getNodeValue());
            } else {
                Element element = (Element) node;
                System.out.println("Transformed element node: " + element.getNodeName());
                printElement(element);
            }
        }
    }

    private static void printElement(Element element) {
        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            if (node.getNodeType() == Node.TEXT_NODE) {
                System.out.println("  - Text node: " + node.getNodeValue());
            } else {
                Element childElement = (Element) node;
                System.out.println("  - Element node: " + childElement.getNodeName());
                printElement(childElement);
            }
        }
    }
}