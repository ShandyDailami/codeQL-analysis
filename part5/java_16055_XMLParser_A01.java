import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_16055_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
            printElement(doc.getDocumentElement(), 1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElement(org.w3c.dom.Element node, int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("  ");
        }
        System.out.println("Element: " + node.getNodeName());

        if (node.hasChildNodes()) {
            for (int i = 0; i < node.getChildNodes().getLength(); i++) {
                printElement((org.w3c.dom.Node) node.getChildNodes().item(i), indent + 1);
            }
        }
    }
}