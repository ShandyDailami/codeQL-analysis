import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_23270_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a factory for the DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Load the XML file
            Document doc = builder.parse(new File("sample.xml"));

            // TODO: Handle the document here.

        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}