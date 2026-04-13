import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_19365_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // create a new factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // create a new document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // parse the XML file
            Document doc = builder.parse(new File("sample.xml"));

            // get the root element
            Element root = doc.getDocumentElement();

            // print all the element names
            printElementNames(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElementNames(Element element) {
        System.out.println("-> " + element.getNodeName());

        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                printElementNames((Element) child);
            } else if (child.getNodeType() == Node.TEXT_NODE) {
                System.out.println("    " + child.getNodeValue());
            }
        }
    }
}