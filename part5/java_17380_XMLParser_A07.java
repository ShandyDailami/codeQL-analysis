import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_17380_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a DocumentBuilderFactory instance
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Step 2: Get a DocumentBuilder instance from the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Parse the XML file into a Document object
            Document document = builder.parse(new File("input.xml"));

            // Step 4: Process the document here (e.g., print the document's tag name)
            document.getDocumentElement().getNodeName();

            // Step 5: Handle the document object (e.g., print the document's text)
            System.out.println(document.getDocumentElement().getTextContent());

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}