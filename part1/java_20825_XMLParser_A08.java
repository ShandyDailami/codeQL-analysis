import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_20825_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Create a factory for building a document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a builder for handling the document
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the file into a Document object
            Document doc = builder.parse(new File("sample.xml"));

            // Print the document element and attributes
            doc.getDocumentElement().normalize();
            System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());

        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}