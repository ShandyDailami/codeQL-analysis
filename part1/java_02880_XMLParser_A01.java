import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class java_02880_XMLParser_A01 {
    public static void main(String[] args) {
        File xmlFile = new File("test.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            doc.getDocumentElement().normalize();
            printElementsAndAttributes(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElementsAndAttributes(Document doc) {
        NodeList nodeList = doc.getElementsByTagName("*");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                printElementAndAttributes(element);
            }
        }
    }

    private static void printElementAndAttributes(Element element) {
        System.out.println("Element: " + element.getTagName());

        for (int i = 0; i < element.getAttributes().getLength(); i++) {
            System.out.println("Attribute: " + element.getAttributes().item(i).getNodeName() + "=" + element.getAttributes().item(i).getTextContent());
        }
    }
}