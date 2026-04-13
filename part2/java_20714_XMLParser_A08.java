import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_20714_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file");
        parseXML(xmlFile);
    }

    private static void parseXML(File xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = builder.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
       
        }

        doc.getElementsByTagName("*");
        printElements(doc);
    }

    private static void printElements(Document doc) {
        NodeList nodeList = doc.getElementsByTagName("*");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Element: " + element.getTagName());
                System.out.println("Attributes: " + element.getAttributes().getLength());

                NodeList childNodes = element.getChildNodes();

                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node childNode = childNodes.item(j);

                    if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element childElement = (Element) childNode;
                        System.out.println("Child Element: " + childElement.getTagName());
                    } else if (childNode.getNodeType() == Node.TEXT_NODE) {
                        System.out.println("Text: " + childNode.getNodeValue());
                    }
                }
            }
        }
    }
}