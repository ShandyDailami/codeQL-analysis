import java.util.List;
import java.util.ArrayList;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileReader;

public class java_23268_XMLParser_A07 {

    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        parseXml(xmlFile);
    }

    public static void parseXml(File xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = null;
        try {
            doc = builder.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        doc.getDocumentElement().normalize();
        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        printElementNames(doc.getDocumentElement());
    }

    public static void printElementNames(Node node) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            System.out.println("Element: " + node.getNodeName());
            if (node.hasChildNodes()) {
                for (Node child = node.getFirstChild(); child != null; child = child.getNextSibling()) {
                    if (child.getNodeType() == Node.ELEMENT_NODE) {
                        printElementNames(child);
                    } else if (child.getNodeType() == Node.TEXT_NODE) {
                        System.out.println("Text: " + child.getNodeValue());
                    }
                }
            }
        }
    }
}