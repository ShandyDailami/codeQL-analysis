import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_28790_XMLParser_A01 {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide an XML file to parse as the argument.");
            return;
        }

        File xmlFile = new File(args[0]);
        if (!xmlFile.exists()) {
            System.out.println("The file " + xmlFile + " does not exist.");
            return;
        }

        parseXML(xmlFile);
    }

    public static void parseXML(File xmlFile) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputStreamReader(new FileInputStream(xmlFile), "UTF-8"));

            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            printNode(doc, doc.getDocumentElement(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printNode(Document doc, org.w3c.dom.Node node, int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("  ");
        }
        System.out.println(node.getNodeName());

        if (node.getNodeType() == NodeList.ELEMENT_NODE) {
            NodeList children = node.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                printNode(doc, children.getItem(i), indent + 1);
            }
        }
    }
}