import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_23958_XMLParser_A01 {

    public static void main(String[] args) {
        String url = "http://example.com/sample.xml"; // Provide a secure URL here
        parseXml(url);
    }

    public static void parseXml(String url) {
        try {
            // Create a new SAXParserFactory
            SAXParserFactory factory = SAXParserFactory.newInstance();

            // Create a new DocumentBuilder using the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Create a new, empty Document object
            Document doc = builder.newDocument();

            // Use the builder to read the input URL and load the Document
            doc.load(url);

            // TODO: Use the document here for any security sensitive operations
            // ...

            System.out.println("XML Parsed successfully");
        } catch (IOException e) {
            System.out.println("Failed to parse XML due to: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Failed to parse XML due to: " + e.getMessage());
        }
    }
}