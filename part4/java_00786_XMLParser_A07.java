import java.io.File;
import java.util.List;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_00786_XMLParser_A07 {

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        parse(inputFile);
    }

    public static void parse(File inputFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = null;
        try {
            document = builder.parse(inputFile);
        } catch (SAXException e) {
            e.printStackTrace();
        }
        document.getDoctype();
        List<Element> elements = new ArrayList<>();
        getAllElements(document.getDocumentElement(), elements);
        printElements(elements);
    }

    private static void getAllElements(Element element, List<Element> elements) {
        elements.add(element);
        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);
            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                getAllElements((Element) childNode, elements);
            }
        }
    }

    private static void printElements(List<Element> elements) {
        for (Element element : elements) {
            System.out.println("Element: " + element.getNodeName());
            NodeList childNodes = element.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node childNode = childNodes.item(i);
                if (childNode.getNodeType() == Node.TEXT_NODE) {
                    System.out.println("Text: " + childNode.getNodeValue());
                }
            }
        }
    }
}