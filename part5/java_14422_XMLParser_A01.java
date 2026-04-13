import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

public class java_14422_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Load the XML file
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File("sample.xml"));

            // Get the root element
            doc.getDocumentElement().normalize();

            // Print the XML file's contents
            printElement(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElement(Node node) {
        System.out.println("------------------------");
        System.out.println("Node Name: " + node.getNodeName());

        if (node.hasChildNodes()) {
            NodeList childNodes = node.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                printElement(childNodes.item(i));
            }
        }

        System.out.println("------------------------");
    }
}