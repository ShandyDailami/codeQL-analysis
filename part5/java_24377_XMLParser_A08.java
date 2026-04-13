import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileReader;

public class java_24377_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory and document
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File("sample.xml"));

            // Show the XML content
            printXML(doc);

            // Continue with your code here

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printXML(Document doc) {
        Element docElement = doc.getDocumentElement();
        System.out.println("Root element : " + docElement.getNodeName());

        NodeList nodeList = doc.getChildNodes();

        for (int temp = 0; temp != nodeList.getLength(); temp++) {
            Node node = nodeList.item(temp);

            if (node instanceof Element) {
                System.out.print("Element : " + node.getNodeName());
            } else if (node instanceof Text) {
                System.out.print("Text : " + node.getNodeValue());
            }
        }
    }
}