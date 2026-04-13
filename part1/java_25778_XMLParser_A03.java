import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class java_25778_XMLParser_A03 {

    public static void main(String[] args) {
        parseXMLFile("example.xml");
    }

    public static void parseXMLFile(String fileName) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true); // Enable validation
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(fileName));

            // Simulate security-sensitive operation related to injection
            String injectionAttempt = "<script>alert('Injection detected!');</script>";
            doc.insertBefore(builder.newDocument(null, injectionAttempt), doc.getFirstChild());

            // Create a transformer to transform the document
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            // Create a DOMSource and a StreamResult
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(System.out);

            // Transform the document
            transformer.transform(source, result);

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}