import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;

public class java_37562_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // create a factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // create a builder
            DocumentBuilder builder = factory.newDocumentBuilder();
            // parse the document
            Document doc = builder.parse(new File("sample.xml"));
            // get the root element
            Element root = doc.getDocumentElement();
            // print all element names
            printElementNames(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElementNames(Element element) {
        System.out.println("Element: " + element.getNodeName());
        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;
                System.out.println("  - " + elem.getNodeName());
                printElementNames(elem);
            }
        }
    }
}