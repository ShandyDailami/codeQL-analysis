import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_29321_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Step 1: Parse the XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new SourceResource("test.xml")); // Replace "test.xml" with your XML file

            // Step 2: Print out the content
            doc.getDocumentElement().normalize();
            printElement(doc, doc.getDocumentElement());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElement(Node node, Node startNode) {
        String indent = "";
        if (startNode != node) {
            indent = indent + "  ";
        }
        System.out.println(indent + node.getNodeName() + ": " + node.getTextContent());
        for (int i = 0; i < node.getChildNodes().getLength(); i++) {
            printElement(node.getChildNodes().item(i), node);
        }
    }
}