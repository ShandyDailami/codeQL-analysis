import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class java_14935_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory and set up an instance to parse the XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(false); // disable validation for security-sensitive operations
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("example.xml")); // parse the XML file

            // Perform security-sensitive operations on the XML document
            // For example, this could be a line of code that modifies the XML document
            document.getDocumentElement().normalize();
            document.getElementsByTagName("tag").item(0).setTextContent("modified content");

            // Create a TransformerFactory and set up an instance to transform the XML document
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(Transformer.OUTPUT_METHOD, "xml");

            // Create a new document for the transformed XML
            Document transformedDocument = builder.newDocument();
            transformer.transform(new DOMSource(document), new StreamResult(transformedDocument));

            // Print the transformed XML
            System.out.println(transformedDocument.getDocumentElement().getNodeValue());

        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}