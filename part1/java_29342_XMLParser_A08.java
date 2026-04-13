import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_29342_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Create a factory for the DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a builder for handling the XML content
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file and store the result in a Document object
            Document doc = builder.parse(new File("example.xml"));

            // Here you can handle the parsed XML data, for example:
            // - Printing all the element names
            // - Printing the values of specific elements
            // - Validating the XML against a specific DTD or XML Schema
            // - Validating the XML against a specific XSD

            // This is just a basic example, in real-world applications you would want to handle errors more gracefully
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}