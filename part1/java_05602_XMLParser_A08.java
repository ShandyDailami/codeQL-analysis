import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_05602_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Create a new DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Create a new DocumentBuilder using the factory
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the input file into a Document object
            Document doc = dBuilder.parse(new FileInputStream("input.xml"));

            // Get the root element of the Document
            doc.getDocumentElement().normalize();

            // Print all the nodes of the Document
            printNodes(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printNodes(Document doc) {
        NodeList nList = doc.getElementsByTagName("node");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nNode " + (temp + 1));

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;

                System.out.println("ID: " + eElement.getAttribute("id"));
                System.out.println("Name: " + eElement.getAttribute("name"));
                System.out.println("Age: " + eElement.getAttribute("age"));
            }
        }
    }
}