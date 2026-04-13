import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileWriter;
import java.io.IOException;

public class java_06751_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // Print the XML file
            printDocument(doc);

            // Save the XML file
            saveDocument(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printDocument(Document doc) {
        System.out.println("\nXML File:");
        Element root = doc.getDocumentElement();
        printNode(root);
    }

    private static void printNode(Node node) {
        if (node.hasChildNodes()) {
            for (Node child = node.getFirstChild(); child != null; child = child.getNextSibling()) {
                printNode(child);
            }
        }
        System.out.println(node.getNodeName());
    }

    private static void saveDocument(Document doc) {
        FileWriter writer = null;
        try {
            writer = new FileWriter("sample_copy.xml");
            doc.write(writer);
            System.out.println("\nXML File Saved!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}