import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_01079_XMLParser_A01 {
    public static void main(String[] args) {
        File xmlFile = new File("example.xml"); // replace with your file
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // print all element names and attributes
            printElementNamesAndAttributes(doc);

        } catch (IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    private static void printElementNamesAndAttributes(Document doc) {
        NodeList nodeList = doc.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Element: " + element.getTagName());
                NodeList attrList = element.getAttributes();
                for (int j = 0; j < attrList.getLength(); j++) {
                    Node attr = attrList.item(j);
                    System.out.println("Attribute: " + attr.getNodeName() + " = " + attr.getTextContent());
                }
            }
        }
    }
}