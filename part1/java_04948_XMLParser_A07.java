import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_04948_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("sample.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();
            System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());

            printElement(doc.getDocumentElement());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElement(org.w3c.dom.Element element) {
        System.out.print("Element Name: " + element.getNodeName());

        // Print all attributes
        if (element.hasAttributes()) {
            System.out.print(" Attributes: ");
            for (int i = 0; i < element.getAttributes().getLength(); i++) {
                System.out.print(element.getAttributes().getItem(i).getNodeName() + " = '" + element.getAttributes().getItem(i).getNodeValue() + "' ");
            }
        }

        // Print child nodes
        System.out.print(" Child Nodes: ");
        for (int i = 0; i < element.getChildNodes().getLength(); i++) {
            if (element.getChildNodes().item(i).getNodeType() == Node.TEXT_NODE) {
                continue;
            }
            System.out.print(" " + element.getChildNodes().item(i).getNodeName());
        }

        System.out.println();

        // Print text node
        if (element.getFirstChild().getNodeType() == Node.TEXT_NODE) {
            System.out.println(" Text: '" + element.getFirstChild().getNodeValue() + "'");
        }

        // Recursive call
        for (int i = 0; i < element.getChildNodes().getLength(); i++) {
            if (element.getChildNodes().item(i).getNodeType() == Node.ELEMENT_NODE) {
                printElement((org.w3c.dom.Element) element.getChildNodes().item(i));
            }
        }
    }
}