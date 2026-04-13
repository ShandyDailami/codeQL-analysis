import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_05074_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Create a new DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Create a new Document
            Document doc = builder.parse(new File("sample.xml"));

            // Print the document to the console
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getElementsByTagName("root").item(0).getTextContent());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}