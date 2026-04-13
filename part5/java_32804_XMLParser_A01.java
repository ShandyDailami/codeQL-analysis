import java.io.File;
import java.util.List;
import java.util.ArrayList;
import org.w3c.dom.*;
import javax.xml.parsers.*;

public class java_32804_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            parseXML("input.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parseXML(String filename) throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File(filename));

        List<String> nodes = new ArrayList<>();
        nodes.add(doc.getDocumentElement().getNodeName());

        printNodes(doc, nodes);
    }

    private static void printNodes(Node node, List<String> nodes) {
        if (node instanceof Element) {
            Element element = (Element) node;
            nodes.add(element.getTagName());
            printNodes(node.getFirstChild(), nodes);
        }
        else if (node instanceof Text) {
            Text text = (Text) node;
            System.out.println(text.getNodeValue());
        }
    }
}