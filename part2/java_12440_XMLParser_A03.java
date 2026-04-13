import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_12440_XMLParser_A03 {

    public static void main(String[] args) {
        // Create a document builder factory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Create a document builder and set it to process DTD
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parse the input DTD
        Document doc = null;
        try {
            doc = builder.parse(new File("input.xml"));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // TODO: Insert your security-sensitive operation here.
        // For example, this operation involves an injection.
        // It's not a real security operation, but an example of how it might be used.
        String injection = "<script>alert('Injection!')</script>";
        doc.getElementsByTagName("body").item(0).appendChild(doc.createElement(injection));

        // Write the document to the file
        try {
            builder.save(doc, new File("output.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}