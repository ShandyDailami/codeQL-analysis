import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class java_16621_XMLParser_A01 {
    public static void main(String[] args) {
        // Load the XML file
        File xmlFile = new File("malicious.xml");

        // Create a DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = null;

        try {
            document = builder.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print out the malicious attribute
        System.out.println("Malicious attribute: " + document.getElementsByTagName("xml").item(0).getAttributes().getNamedItem("file"));

        // Parse the XML file
        // Here we're just printing out the malicious attribute to the console. In a real-world application,
        // you'd replace this with some kind of security-sensitive operation.

        // Print out the malicious attribute
        System.out.println("Malicious attribute: " + document.getElementsByTagName("xml").item(0).getAttributes().getNamedItem("file"));

        // Create a new XML file
        Document newDocument = builder.newDocument();

        // Add a malicious attribute to the root element
        org.w3c.dom.Element root = newDocument.createElement("xml");
        root.setAttribute("file", "malicious.txt");
        newDocument.appendChild(root);

        // Save the new XML file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(newDocument);
        StreamResult result = new StreamResult(System.out);
        transformer.transform(source, result);

        // Print out the new XML file
        System.out.println("New XML file: " + System.getProperty("java.io.tmpdir") + "malicious.xml");
    }
}