import java.util.List;
import java.util.stream.Stream;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;

public class java_40453_XMLParser_A01 {

    public static void main(String[] args) {
        parseXmlFile("src/test.xml");
    }

    public static void parseXmlFile(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = null;

        try {
            document = builder.parse(new File(fileName));

            document.getDocumentElement().normalize();

            // Print all the nodes
            printNodes(document);

            // Print all the element nodes
            printElementNodes(document);

            // Print all the attribute nodes
            printAttributeNodes(document);

        } catch (ParserConfigurationException | SAXException | java.io.IOException e) {
            e.printStackTrace();
        }
    }

    private static void printNodes(Document document) {
        @SuppressWarnings("unchecked")
        List<Node> nodes = document.getChildNodes();
        nodes.stream()
                .filter(node -> node.getNodeType() == Node.TEXT_NODE)
                .map(node -> ((Text) node).getNodeValue())
                .forEach(System.out::println);
    }

    private static void printElementNodes(Document document) {
        @SuppressWarnings("unchecked")
        List<Node> nodes = document.getChildNodes();
        nodes.stream()
                .filter(node -> node.getNodeType() == Node.ELEMENT_NODE)
                .map(node -> ((Element) node).getNodeName())
                .forEach(System.out::println);
    }

    private static void printAttributeNodes(Document document) {
        @SuppressWarnings("unchecked")
        List<Node> nodes = document.getChildNodes();
        nodes.stream()
                .filter(node -> node.getNodeType() == Node.ATTRIBUTE_NODE)
                .map(node -> ((Attribute) node).getName())
                .forEach(System.out::println);
    }
}