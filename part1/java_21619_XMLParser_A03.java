import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_21619_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Step 2: Get a document builder from the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Parse the XML file
            Document doc = builder.parse(new File("sample.xml"));

            // Step 4: Handle the document
            // This is where you would handle your document, such as
            // retrieving elements, attributes, and text, etc.

            // This is a simple example, so we won't be handling the document

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}