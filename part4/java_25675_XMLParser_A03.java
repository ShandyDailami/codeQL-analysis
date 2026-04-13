import java.io.File;
import java.util.Stack;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_25675_XMLParser_A03 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        parse(inputFile);
    }

    private static void parse(File inputFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc;
        try {
            doc = builder.parse(inputFile);
            doc.getDocumentElement().normalize();
            printElements(doc, new Stack<String>());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElements(Document doc, Stack<String> path) {
        NodeList nodes = doc.getElementsByTagName("*");
        for (int i = 0; i < nodes.getLength(); ++i) {
            printElement(nodes.item(i), path);
        }
    }

    private static void printElement(Node node, Stack<String> path) {
        Element element = (Element) node;
        String name = element.getTagName();
        path.push(name);
        System.out.println(String.join(".", path));

        // print attributes
        for (int i = 0; i < element.getAttributes().getLength(); ++i) {
            System.out.println(element.getAttributes().item(i).getNodeName() + "=" + element.getAttributes().item(i).getTextContent());
        }

        // print child elements
        printElements(element, path);
        path.pop();
    }
}