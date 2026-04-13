import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class java_12106_XMLParser_A08 {

    public static void main(String[] args) {
        // Creating XML Parser
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Loading XML file
        Document doc = builder.parse(new File("sample.xml"));
        doc.getDocumentElement().normalize();

        // Displaying the data
        printNodes(doc.getElementsByTagName("student"));

        // Writing XML back to file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("sample-copy.xml"));
        transformer.transform(source, result);
    }

    private static void printNodes(NodeList nodes) {
        for (int i = 0; i < nodes.getLength(); i++) {
            Element element = (Element) nodes.item(i);
            System.out.println("Element: " + element.getTagName());
            System.out.println("Content: " + element.getTextContent());
        }
    }
}