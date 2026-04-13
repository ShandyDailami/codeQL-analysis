import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_18544_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("yourfile.xml"); // replace with your file path
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // Print all element names
            printElementNames(doc);

            // Print all element values
            printElementValues(doc);

            // Print all element names with specific value
            printElementNamesWithValue("your_value", doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElementNames(Document doc) {
        NodeList nodeList = doc.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Element name: " + element.getTagName());
            }
        }
    }

    private static void printElementValues(Document doc) {
        NodeList nodeList = doc.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Element value: " + element.getFirstChild().getNodeValue());
            }
        }
    }

    private static void printElementNamesWithValue(String value, Document doc) {
        NodeList nodeList = doc.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                if (element.getFirstChild().getNodeValue().equals(value)) {
                    System.out.println("Element name: " + element.getTagName());
                }
            }
        }
    }
}