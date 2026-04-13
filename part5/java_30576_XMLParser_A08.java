import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_30576_XMLParser_A08 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(inputFile);

            System.out.println("Parsing completed successfully.");

        } catch (SAXException e) {
            System.out.println("Parsing failed: " + e.getMessage());

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}