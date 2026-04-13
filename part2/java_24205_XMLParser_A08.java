import java.io.File;
import java.security.InvalidParameterException;
import java.util.Stack;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_24205_XMLParser_A08 {
    private Stack<String> stack = new Stack<>();

    public void parse(String filePath) {
        File xmlFile = new File(filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            printElements(document);

        } catch (Exception e) {
            throw new InvalidParameterException("Error parsing XML file", e);
        }
    }

    private void printElements(Document document) {
        NodeList nodeList = document.getElementsByTagName("*");

        for (int i = 0; i < nodeList.getLength(); i++) {
            printElement(nodeList.item(i));
        }
    }

    private void printElement(org.w3c.dom.Node node) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            stack.push(node.getNodeName());

            if (node.hasChildNodes()) {
                printElements(node);
            } else {
                printContent(node);
            }

            stack.pop();
        }
    }

    private void printContent(org.w3c.dom.Node node) {
        if (node.getNodeType() == Node.TEXT_NODE) {
            System.out.println(stack.toString() + ": " + node.getTextContent().replaceAll("\\R", " "));
        }
    }

    public static void main(String[] args) {
        XMLParser parser = new XMLParser();
        parser.parse("path/to/your/xml/file");
    }
}