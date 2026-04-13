import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import javax.xml.transform.Transformer;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class java_10147_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a factory for building a new Document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML document and load it into the DOM
            Document doc = builder.parse(new File("example.xml"));

            // Create a Transformer to transform the XML document into another format
            Transformer transformer = transformer = TransformerFactory.newInstance().newTransformer();

            // Configure the Transformer
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            // Set the output to a file
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("output.xml"));

            // Transform the XML document into another format
            transformer.transform(source, result);

            System.out.println("XML file has been parsed and transformed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}