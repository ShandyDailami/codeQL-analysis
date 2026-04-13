import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_00181_XMLParser_A03 {

    public static void main(String[] args) {
        // Step 1: Initialize the DocumentBuilderFactory
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        // Step 2: Obtain DocumentBuilder from factory
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        // Step 3: Parse the XML file
        Document doc = dBuilder.parse(new File("input.xml"));

        // Step 4: Handle the document (optional)
        System.out.println("Root element : " + doc.getDocumentElement().getNodeName());

        // This will print all the nodes names and attributes
        printElement(doc);

    }

    // Recursive method to print all nodes and their attributes
    private static void printElement(Document doc) {
        NodeList nodeList = doc.getElementsByTagName("*");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Node name : " + element.getNodeName());
                printElement(element);
            }
        }
    }

}