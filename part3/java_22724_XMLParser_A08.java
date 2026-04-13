import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_22724_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("input.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            // Print out the parsed data
            printData(document);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printData(Document document) {
        NodeList nodeList = document.getElementsByTagName("element");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            System.out.println("Data at node " + (i + 1) + ": " + node.getTextContent());
        }
    }
}