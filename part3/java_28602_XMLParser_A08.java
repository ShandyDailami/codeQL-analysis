import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class java_28602_XMLParser_A08 {
    public static void main(String[] args) {
        // Create DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // Create DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("example.xml"));

            // Print out the parsed XML
            System.out.println("Parsed XML file successfully.");

            // Create TransformerFactory
            TransformerFactory transformerFactory = TransformerFactory.newInstance();

            // Create Transformer
            Transformer transformer = transformerFactory.newTransformer();

            // Prepare the DOM Source
            DOMSource source = new DOMSource(doc);

            // Prepare the result
            StreamResult result = new StreamResult(System.out);

            // Transform the document
            transformer.transform(source, result);

            // Print out the transformed XML
            System.out.println("\nTransformed XML:");

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}