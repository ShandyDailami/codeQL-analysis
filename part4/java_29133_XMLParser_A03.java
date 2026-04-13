import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_29133_XMLParser_A03 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        File inputFile = new File("input.xml");
        Document doc;
        try {
            doc = builder.parse(inputFile);
            System.out.println("Document loaded successfully.");
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("Error parsing the document: " + e.getMessage());
            return;
        }

        // Add your code here to parse the document and process the data
    }
}