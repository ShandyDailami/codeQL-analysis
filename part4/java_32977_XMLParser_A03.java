import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_32977_XMLParser_A03 {
    public static void main(String[] args) {
        // Creating DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // Creating DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parsing the input file
            Document doc = builder.parse(new File("input.xml"));

            // Handle the parsed document
            // ...

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}