import java.io.File;
import java.util.Stack;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_03914_XMLParser_A07 {
    private Stack<Element> elementStack;

    public java_03914_XMLParser_A07() {
        elementStack = new Stack<Element>();
    }

    public void parse(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File(fileName));
        doc.getDocumentElement().normalize();
        Element root = doc.getDocumentElement();
        printElement("", root);
    }

    private void printElement(String indent, Element element) {
        System.out.println(indent + element.getTagName());
        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            if (node.getNodeType() == Node.TEXT_NODE) {
                // do nothing
            } else if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element childElement = (Element) node;
                printElement(indent + "  ", childElement);
            }
        }
    }
}