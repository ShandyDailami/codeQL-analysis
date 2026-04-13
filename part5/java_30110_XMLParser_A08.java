import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_30110_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            // print all the elements in the document
            printElements(document);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElements(Document document) {
        NodeList nodeList = document.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Element: " + element.getTagName());
                System.out.println("Attributes:");
                for (int j = 0; j < element.getAttributes().getLength(); j++) {
                    System.out.println(element.getAttributes().item(j).getNodeName() + " = " + element.getAttributes().item(j).getTextContent());
                }
                printElements(element);
            } else if (node.getNodeType() == Node.TEXT_NODE) {
                System.out.println("Text: " + node.getTextContent());
            }
        }
    }
}