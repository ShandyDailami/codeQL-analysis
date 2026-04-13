import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_35292_XMLParser_A03 {
    public static void main(String[] args) {
        String fileName = "example.xml";
        parseXMLFile(fileName);
    }

    public static void parseXMLFile(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(fileName));

            // Print out the parsed information
            printDocument(doc);

        } catch (IOException e) {
            System.out.println("Error reading the XML file: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Error parsing the XML file: " + e.getMessage());
        }
    }

    public static void printDocument(Document doc) {
        // TODO: Implement printDocument method
        // This method prints out the content of the Document to the console.
        // You may use the JAXP API's methods or your own custom implementation.
    }
}