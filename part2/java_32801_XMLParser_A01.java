import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_32801_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();
            printElement(doc, doc.getDocumentElement());

            System.out.println("Parsing completed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElement(Document doc, Element elem) {
        if (elem == null) {
            return;
        }

        String nodeName = elem.getNodeName();
        System.out.println(nodeName);

        if (elem.hasAttributes()) {
            Node node2 = elem.getFirstChild();
            while (node2 != null) {
                Node node3 = node2.getNextSibling();

                if (node2 instanceof Element) {
                    printElement((Document) doc, (Element) node2);
                }
                node2 = node3;
            }
        }
    }
}