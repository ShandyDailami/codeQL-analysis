import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_32378_XMLParser_A01 {

    public static void main(String[] args) {

        // Load the XML file
        File file = new File("src/main/resources/example.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            // TODO: parse XML and print out the content
            // This is just a placeholder. Real implementation would handle the parsed XML and print out its content.
            System.out.println("XML parsed successfully!");

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}