import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class java_05695_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilder
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Load the XML file
            Document doc = dBuilder.parse(new File("sample.xml"));

            // Normalize the XML file
            doc.getDocumentElement().normalize();

            // Print all data in the XML file
            printElements(doc);

            // Transform the XML file
            transformDocument(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printElements(Document doc) {
        NodeList nList = doc.getElementsByTagName("*");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("  - Node Name: " + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("    - Attribute: " + eElement.getAttribute("id"));
            }
        }
    }

    public static void transformDocument(Document doc) {
        try {
            // Create a Transformer
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            // Set the source to be an XML file
            Source xslt = new StreamSource(new File("sample.xslt"));

            // Set the destination to be an HTML file
            Result xsltResult = new StreamResult(new File("output.html"));

            // Transform the document
            transformer.transform(xslt, xsltResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}