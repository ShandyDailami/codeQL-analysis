import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.List;
import java.util.ArrayList;

public class java_23261_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("example.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("*");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    List<String> names = new ArrayList<>();
                    names.add(element.getTagName());
                    names.addAll(parseElement(element));
                    System.out.println(names);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<String> parseElement(Element element) {
        List<String> names = new ArrayList<>();
        names.add(element.getAttribute("name"));
        names.add(element.getAttribute("type"));
        names.add(element.getTextContent());

        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);
            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                names.addAll(parseElement((Element) childNode));
            }
        }
        return names;
    }
}