import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_00508_XMLParser_A07 {

    public static void main(String[] args) {
        // Step 1: Create a DocumentBuilderFactory instance.
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Step 2: Get the DocumentBuilder from the factory.
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            // Step 3: Parse the XML document.
            Document document = builder.parse(new File("authFailure.xml"));

            // TODO: Add your code here to handle the XML document.

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}