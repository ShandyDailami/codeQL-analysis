import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_07576_XMLParser_A01 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = null;

        try (FileInputStream fis = new FileInputStream(inputFile)) {
            doc = dBuilder.parse(fis);
            doc.getDocumentElement().normalize();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        printNode(doc.getElementsByTagName("note"));
    }

    private static void printNode(NodeList nodes) {
        for (int i = 0; i < nodes.getLength(); i++) {
            printNode(nodes.item(i));
        }
    }

    private static void printNode(org.w3c.dom.Node node) {
        System.out.println("  " + node.getNodeName() + " : " + node.getTextContent());

        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            printNode(children.item(i));
        }
    }
}