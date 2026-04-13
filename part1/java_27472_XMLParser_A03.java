import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_27472_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a new instance of the DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document document = builder.parse(new File("example.xml"));

            // Here, you can manipulate the document using the DOM (Document Object Model) API.
            // For example, you can print the XML file's title and body.
            document.getDocumentElement().normalize();
            System.out.println("Title: " + document.getElementsByTagName("title").item(0).getTextContent());
            System.out.println("Body: " + document.getElementsByTagName("body").item(0).getTextContent());

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}