import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_38027_XMLParser_A07 {
    public static void main(String[] args) {
        String fileName = "example.xml"; // replace with your XML file
        parseXMLFile(fileName);
    }

    private static void parseXMLFile(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false); // disable validation for testing
        DocumentBuilder builder = factory.newDocumentBuilder();

        try (InputStream inputStream = new FileInputStream(fileName)) {
            Document document = builder.parse(inputStream);

            // print the parsed document in console
            // XMLPrinter.printDocument(document);

            // perform operations on document...
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}