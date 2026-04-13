import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Stack;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_00075_XMLParser_A01 {

    private Stack<Element> elementStack;

    public java_00075_XMLParser_A01() {
        elementStack = new Stack<>();
    }

    public void parse(String fileName) throws IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(fileName));

        document.getDocumentElement().normalize();
        elementStack.push(document.getDocumentElement());

        visit(document.getDocumentElement());
    }

    private void visit(Element element) {
        System.out.println("Start: " + element.getNodeName());

        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                Element childElement = (Element) child;
                elementStack.push(childElement);
                visit(childElement);
            }
        }

        System.out.println("End: " + element.getNodeName());
    }
}