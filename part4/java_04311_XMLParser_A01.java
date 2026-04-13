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

public class java_04311_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Load the XML document
            File xmlFile = new File("path_to_your_file.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            // Print the XML file
            printXml(doc);

            // Modify the XML file
            modifyXml(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printXml(Document doc) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Transformer transformer = dBuilder.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(System.out);
        transformer.transform(source, result);
    }

    private static void modifyXml(Document doc) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document newDoc = dBuilder.newDocument();

        // Create root element
        Element rootElement = newDoc.createElement("root");
        newDoc.appendChild(rootElement);

        // Create and append new elements
        Element element1 = newDoc.createElement("element1");
        element1.appendChild(newDoc.createTextNode("value1"));
        rootElement.appendChild(element1);

        Element element2 = newDoc.createElement("element2");
        element2.appendChild(newDoc.createTextNode("value2"));
        rootElement.appendChild(element2);

        // Print the modified XML file
        printXml(newDoc);
    }
}