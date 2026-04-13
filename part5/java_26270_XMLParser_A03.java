import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_26270_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Parse the XML document
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File("input.xml"));

            // Print out all the tags in the document
            printTags(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printTags(Document doc) {
        NodeList nodeList = doc.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            printTag(nodeList.item(i));
        }
    }

    public static void printTag(Node node) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            System.out.println(node.getNodeName());
        }
    }
}