import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_13786_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a DocumentBuilderFactory and a Document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("input.xml"));

            // Step 2: Use Document to perform security-sensitive operations
            // Here, we are just printing the document title. 
            // This operation is security-sensitive because it can print the title of the document
            System.out.println("Document title: " + doc.getDocumentElement().getElementsByTagName("title").item(0).getTextContent());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}