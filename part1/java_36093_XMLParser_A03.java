import java.util.Stack;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import javax.xml.transform.Transformer;
import javax.xml.transform.Transformers;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class java_36093_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlFile = "sample.xml";
        parseXmlFile(xmlFile);
    }

    private static void parseXmlFile(String xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            File inputFile = new File(xmlFile);
            javax.xml.validation.Schema schema = javax.xml.validation.SchemaLoader.newInstance().load(new File("sample.xsd"));

            builder.setEntityResolver(new MyEntityResolver());
            builder.setErrorHandler(new MyErrorHandler());

            Document document = builder.parse(inputFile);

            printElementNames(document.getElementsByTagName("*"));

            Transformer transformer = Transformers.newTransformer();
            transformer.setOutputProperty(Transformer.OutputProperty.INDENT, "yes");
            transformer.transform(new DOMSource(document), new StreamResult(System.out));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElementNames(NodeList list) {
        Stack<Node> stack = new Stack<>();
        stack.push(list.getLength() == 1 ? list.item(0) : list);

        while (!stack.isEmpty()) {
            Node node = stack.pop();

            if (node instanceof Element) {
                System.out.println("Element name: " + node.getNodeName());
            }

            if (node instanceof org.w3c.dom.NodeList) {
                stack.push(node);
            }

            NodeList children = ((Element) node).getElements();
            for (int i = 0; i < children.getLength(); i++) {
                stack.push(children.item(i));
            }
        }
    }
}