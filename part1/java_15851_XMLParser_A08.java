import java.io.File;
import java.util.Optional;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class java_15851_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("path/to/your/xml/file.xml"); // Provide your xml file path

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            printDocument(doc);

            // Modify the document and print it again
            modifyDocument(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printDocument(Document doc) {
        Document prettyDoc = transformToPrettyPrint(doc);
        DOMSource source = new DOMSource(prettyDoc);
        StreamResult result = new StreamResult(System.out);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(source, result);
    }

    private static Document transformToPrettyPrint(Document doc) throws TransformerException {
        Document prettyDoc = doc.getImplementation().createDocument(null, "pretty-print", null);
        Element root = doc.getDocumentElement();
        prettyDoc.appendChild(prettyDoc.importNode(root, true));
        return prettyDoc;
    }

    private static void modifyDocument(Document doc) throws TransformerException {
        Element root = doc.getDocumentElement();
        // Change the value of the root element's attribute 'name'
        root.setAttribute("name", "newName");
        // Add a new child element to the root element
        Element child = doc.createElement("child");
        child.setTextContent("child content");
        root.appendChild(child);
    }
}