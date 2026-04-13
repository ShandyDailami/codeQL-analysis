import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class java_09427_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a DocumentBuilderFactory and set up the parser
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 2: Use the DocumentBuilder to parse the XML file
            Document doc = builder.parse(new File("sample.xml"));

            // Step 3: Print the XML structure
            printDocument(doc);

            // Step 4: Write the parsed XML to a new file
            writeDocument(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to print the XML structure
    private static void printDocument(Document doc) {
        System.out.println(doc.getDocumentElement().getNodeName());
    }

    // Method to write the parsed XML to a new file
    private static void writeDocument(Document doc) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("new_sample.xml"));
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}