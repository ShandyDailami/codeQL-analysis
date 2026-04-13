import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_29853_XMLParser_A08 {

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(new File("example.xml"));
            document.normalize();

            List<String> nodes = getNodes(document, "node1", "node2");
            for (String node : nodes) {
                System.out.println(node);
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static List<String> getNodes(Document document, String... nodeNames) {
        List<String> nodes = new ArrayList<>();
        for (String nodeName : nodeNames) {
            NodeList nodeList = document.getElementsByTagName(nodeName);
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                nodes.add(element.getTextContent());
            }
        }
        return nodes;
    }
}